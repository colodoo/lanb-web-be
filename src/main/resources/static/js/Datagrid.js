/**
 * 简化datagrid代码
 * @param options
 */
function datagrid(options) {
    var menuName = options.menuName || 'testSetting';// 功能名
    var clearForm = true;
    if (options.clearForm != null) {
        clearForm = options.clearForm;//在新增的时候是否清理
    }
    if (menuName == null)// 不存在该参数则不处理
        return;
    var extra = options.extra || {};//额外配置
    var menuTitle = options.menuTitle || '测试设置';// 功能标题
    var defaultColumns = [[
        {
            field: 'testId',
            title: '测试ID',
            width: 50,
            hidden: true
        }, {
            field: 'testName',
            title: '测试名',
            width: 50
        }, {
            field: 'createTime',
            title: '创建时间',
            width: 50,
            formatter: dateFormatter
        }
    ]];
    var columns = options.columns || defaultColumns;// 字段
    var pk = options.pk || 'testId';// 主键字段名
    var defaultApi = {
        save: '/test/save',
        delete: '/test/delete',
        update: '/test/update',
        query: '/test/query'
    }
    var callback = options.callback || function () {
    }// 回调事件
    var api = options.api || defaultApi;// 接口
    var dg = '#' + menuName + 'Dg';// 数据表格
    var dlg = '#' + menuName + 'Dlg';// 对话框
    var fm = '#' + menuName + 'Fm';// 表单
    var toolbar = '#' + menuName + 'Toolbar';// 工具栏

    return {
        // 组件
        dg: $(dg),
        dlg: $(dlg),
        fm: $(fm),
        toolbar: $(toolbar),

        url: api.query,// 默认为查询接口

        initTable: function () {
            var self = this;
            var bsOpt = {
                url: this.url,
                toolbar: toolbar,
                pagination: true,
                rownumbers: true,
                fitColumns: true,
                singleSelect: true,
                title: menuTitle,
                border: true,
                columns: columns,
                onDblClickRow: function (index, row) {
                    self.edit();
                }
            };
            var opt = $.extend(bsOpt, extra);
            $(dg).datagrid(opt);
            callback();// 在初始化完成以后进行回调操作,以免发生问题
        },

        new: function () {
            $(dlg).dialog('open').dialog('center').dialog('setTitle', menuTitle + '新增');
            if (clearForm) {
                $(fm).form('clear');
            }
            this.url = api.save;
        },

        destroy: function () {
            var row = $(dg).datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确认要删除该项?', function (r) {
                    if (r) {
                        var tmp = {};
                        tmp[pk] = row[pk];
                        $.post(api.delete, tmp, function (result) {
                            if (result.success) {
                                $(dg).datagrid('reload');
                                $.messager.show({title: '信息', msg: "操作成功"});
                            } else {
                                $.messager.show({title: '错误', msg: result.errorMsg});
                            }
                        }, 'json');
                    }
                });
            }
        },

        edit: function () {
            var row = $(dg).datagrid('getSelected');
            if (row) {
                $(dlg).dialog('open').dialog('center').dialog('setTitle', menuTitle + '编辑');
                $(fm).form('load', row);
                this.url = api.update;
            }
        },

        save: function () {
            $(fm).form('submit', {
                url: this.url, onSubmit: function () {
                    return $(this).form('validate');
                }, success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.errorMsg) {
                        $.messager.show({title: '错误', msg: result.errorMsg});
                    } else {
                        $(dlg).dialog('close');
                        $(dg).datagrid('reload');
                        $.messager.show({title: '信息', msg: "操作成功"});
                    }
                }
            });
        }
    }
}