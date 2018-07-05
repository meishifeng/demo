<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <style type="text/css">
    body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
  </style>
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2t5njLXtPd4ZUQckO0nLllMDATx2iHRY"></script>
  <title>地图展示</title>
</head>
<body>
  <div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
  // 百度地图API功能
  var map = new BMap.Map("allmap"/*,{mapType: BMAP_HYBRID_MAP}*/);    // 创建Map实例
  map.centerAndZoom(new BMap.Point(114.162075, 30.525102), 11);  // 初始化地图,设置中心点坐标和地图级别
  map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
  map.addControl(new BMap.NavigationControl()); // 添加平移缩放控件
  map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
  map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

  map.addControl(new BMap.ScaleControl({type:BMAP_NAVIGATION_CONTROL_SMALL}));  //比例尺控件

  //单独设定图标的样式
  var icon = new BMap.Icon('/web/images/map_list_bg.png', new BMap.Size(25, 35), {
    anchor: new BMap.Size(10, 30)
  });
  //创建一个图像标注实例。point参数指定了图像标注所在的地理位置
  var mkr = new BMap.Marker(new BMap.Point(114.162075,30.525102), {
    icon: icon
  });

  //将覆盖物添加到地图中
  map.addOverlay(mkr);

//  var buildingOverlay = new OverlayMark(new BMap.Point(114.162075,30.525102), "哈哈哈哈哈哈哈哈哈哈哈或", 1);
//
//  function OverlayMark(point, text, type) {
//    this._point = point;
//    this._text = text;
//    this._type = type;
//    this._i = i;
//    this.enableClear = (type == 1 || type == '1') ? false : true;
//  }
//  OverlayMark.prototype = new BMap.Overlay();
//  OverlayMark.prototype.initialize = function(map) {
//    this._map = map;
//  };
//  OverlayMark.prototype.draw = function() {
//    var map = this._map;
//    var pixel = map.pointToOverlayPixel(this._point);
//  };
//
//  map.addOverlay(buildingOverlay);


</script>
