# 需求说明
模拟实现十字路口的交通灯管理系统逻辑。详细需求例如以下：

1、异步随机生成依照各个路线行驶的车辆。

比如： 由南向而来去往北向的车辆 ---- 直行车辆 由西向而来去往南向的车辆 ---- 右转车辆 由东向而来去往南向的车辆 ---- 左转车辆 。。。。。

2、信号灯忽略黄灯，仅仅考虑红灯和绿灯。

3、应考虑左转车辆控制信号灯，右转车辆不受信号灯控制。

4、详细信号灯控制逻辑与现实生活中普通交通灯控制逻辑同样。不考虑特殊情况下的控制逻辑。

注：直行与左转同一信号灯，绿灯依次按照 北 东 南 西 的顺时针顺序点亮

5、每辆车通过路口时间为1秒（提示：可通过线程Sleep的方式模拟）。

6、随机生成车辆时间间隔以及红绿灯交换时间间隔自定，能够设置。

7、不要求实现GUI。仅仅考虑系统逻辑实现，可通过Log方式展现程序执行结果。