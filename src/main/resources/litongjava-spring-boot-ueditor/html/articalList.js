var uri = projectName + '/article';
var title = "文章管理";
var active;
var cols = [
  [
    { checkbox: true }, //开启多选框
    { field: 'id', width: 150, title: 'ID' },
    { field: 'title', width: 150, title: '标题' },
    { field: 'type', width: 150, title: "类型" },
    { field: 'content', width: 150, title: '文章' },
    { fixed: 'right', title: '操作', toolbar: '#operation-btns' }
  ]
]

layui.use(['table', 'layer', 'form', 'laypage'], function() {
  var table = layui.table,
    layer = layui.layer,
    form = layui.form,
    laypage = layui.laypage;
  $ = layui.$;

  table.render({
    id: "data-table",
    elem: '#data-table',
    url: uri + '/list',
    page: true,
    method: 'post',
    toolbar: '#toolBar',
    limit: 10,
    request: { pageName: 'pageNo', limitName: 'pageSize' },
    response: { statusName: 'code', msgName: 'msg', dataName: 'data', countName: 'count' },
    cols: cols,
    limits: [5, 10, 20, 50],
    done:tableDone,
  });

  table.on('tool(data-table)', function(obj) {
    var data = obj.data;
    switch (obj.event) {
      case 'edit':
        window.formData = obj.data;
        layerOpenForm(layer, title + "编辑页面", "articleForm.html");
        break;
      case 'del':
        var delIndex = layer.confirm('真的删除id为' + data.id + "的信息吗?", function(delIndex) {
          $.ajax({
            url: uri + '/del?id=' + data.id,
            type: "post",
            success: function(response) {
              if (response.code == 0) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(delIndex);
                layer.msg("删除成功", { icon: 1 });
              } else {
                layer.msg("删除失败", { icon: 5 });
              }
            }
          });
          layer.close(delIndex);
        });
        break;
      case 'preview':
        var winHandler = window.open('', '_blank')
        winHandler.location.href = './articlePreview.html?id='+data.id;
        break;
    }
  });

  //监听搜索
  form.on('submit(front-search)', function(data) {
    var field = data.field;
    //console.log("filed:", field);
    //执行重载
    table.reload('data-table', {
      where: field
    });
  });
  //事件
  active = {
    add: function() {
      layerOpenForm(layer, title + "添加页面", "articleForm.html");
    },
    batchdel: function() {
      //debugger;
      var checkStatus = table.checkStatus('data-table'),
        checkData = checkStatus.data; //得到选中的数据
      if (checkData.length === 0) {
        return layer.msg('请选择数据');
      }

      layer.confirm('确定删除多条数据吗？', function(index) {
        var ids = new Array();
        for (var i = 0; i < checkData.length; i++) {
          ids.push(checkData[i].id);
        }
        $.ajax({
          url: uri + "/removeByIds",
          type: "post",
          data: { ids: ids },
          success: function(resp) {
            if (resp.code == 0) {
              //layer.msg("删除成功", { icon: 1 });
            } else {
              layer.msg("删除失败", { icon: 5 });
            }
          },
        });
        //执行 Ajax 后重载
        table.reload('data-table');
        layer.msg("删除成功", { icon: 1 });
      });
    },
  };
  $("body").on('click', '.layui-btn-container .layui-btn', function() {
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});