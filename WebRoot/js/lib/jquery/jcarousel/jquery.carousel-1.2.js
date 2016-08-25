//焦点图
// scale               照片宽高比例
// height_padding      高度补白
// position_bottom     按钮底边距

$.fn.carousel = function (scale,height_padding,position_bottom) {
    //变量
    var box_width = $(this).width(),
        ul = $(this).children('ul'),
        ul_li = ul.children('li'),
        len = ul_li.length,
        index = 0,
        timeout;
    // 根据子元素数量，设置ul宽度
    ul_li.css('width', box_width);
    ul.css('width', box_width * (len));

    // 设置容器高度

    $(this).height(box_width * scale + parseInt(height_padding));

    // 构建页码按钮
    var control = '<div class="control" style="bottom:'+position_bottom+'px">';
    for (var i = 1; i <= len; i++) {
        control += '<span>' + i + '</span>';
    };

    //组合成页码按钮和左右控制键
    control += '</div><span class="pre"></span><span class="next"></span>';

    //追加到容器内
    $(this).append(control);

    //为新追加的按钮设置变量
    var btn_control_span = $(this).find('.control span'),
        btn_pre_next = $(this).find('.pre,.next'),
        active_index;

    //激活第1个页码按钮
    btn_control_span.eq(0).addClass('active');

    //页码按钮经过
    btn_control_span.mouseover(function () {
        index = $(this).index();
        carousel_show(index);
    });

    //上一个
    $(this).find('.pre').click(function () {
        //获取当前选择按钮的索引
        index=btn_control_span.filter('.active').index();
        index--;
        if (index == -1) {
            index = len - 1;
        }
        carousel_show(index);
    });

    //下一个
    $(this).find('.next').click(function () {
        //获取当前选择按钮的索引
        index=btn_control_span.filter('.active').index();
        index++;
        if (index == len) {
            index = 0;
        }
        carousel_show(index);

    });

    //切换效果
    function carousel_show(index) {
        ul.stop(true, false).animate({
            'left': -index * box_width
        }, 300);
        btn_control_span.stop(true, false).eq(index).addClass('active').siblings().removeClass('active');
    }

    //经过和离开效果
    $(this).hover(function () {
        //取消循环
        clearInterval(timeout);
        //显示按钮
        btn_pre_next.stop(true, false).fadeIn();

    }, function () {
        //隐藏按钮
        btn_pre_next.stop(true, false).fadeOut();
        //设置循环
        timeout = setInterval(function () {
            carousel_show(index);
            index++;
            if (len == index) {
                index = 0;
            }
        }, 3000)
    }).trigger("mouseleave");
}
