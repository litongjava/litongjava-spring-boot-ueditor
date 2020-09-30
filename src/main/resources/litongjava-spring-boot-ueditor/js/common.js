var projectName = '/litongjava-spring-boot-ueditor';

function layerOpenForm(layer, title, content) {
  var w = ($(window).width() * 0.7);
  var h = ($(window).height() - 50);
  var index = layer.open({
    type: 2,
    title: title,
    area: ['60%', '60%'],
    fix: false,
    maxmin: true,
    shadeClose: true,
    shade: 0.4,
    skin: 'layui-layer-lan',
    content: content,
  });
}

var tableDone=function(res, curr, count) {
  $('th').css({ 'background-color': '#ef6800', 'color': '#fff' });
}
var request = {
  getParamter: function(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for(var i = 0; i < vars.length; i++) {
      var pair = vars[i].split("=");
      if(pair[0] == variable) {
        return pair[1];
      }
    }
    return(false);
  }
}