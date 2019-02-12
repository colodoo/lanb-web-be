$(function () {
    $.extend({
        /**
         * 新建一个窗口
         * @param options
         * @returns {jQuery}
         */
        getWindow: function (options) {
            var id = options.id || '';
            var defaultOption = {
                width: 600,
                height: 450,
                modal: true
            };
            options = $.extend(defaultOption, options);
            if (id == '') {
                return;
            } else {
                var hander = $("<div id='" + id + "'><div>'").text("");
                $("body").append(hander);
                $('#' + id).window(options);
                return hander;
            }
        }
    });
})

/**
 * 时间格式化
 * @param value
 * @returns {string}
 */
function dateFormatter(value) {
    var date = new Date(value);
    var year = date.getFullYear().toString();
    var month = (date.getMonth() + 1);
    var day = date.getDate().toString();
    var hour = date.getHours().toString();
    var minutes = date.getMinutes().toString();
    var seconds = date.getSeconds().toString();
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
}

/**
 * 解析时间
 */
function dateParser(s) {
    if (s == "")
        return new Date().getTime();
    var date = new Date(s);
    var year = date.getFullYear().toString();
    var month = (date.getMonth() + 1);
    var day = date.getDate().toString();
    var hour = date.getHours().toString();
    var minutes = date.getMinutes().toString();
    var seconds = date.getSeconds().toString();
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    var str = year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    return str;
}

$.fn.datebox.defaults.formatter = dateFormatter;
$.fn.datetimebox.defaults.parser = dateParser;