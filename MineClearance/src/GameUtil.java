
/*
* 工具类
* 存放静态参数
* 工具方法
* */

import java.awt.*;

public class GameUtil
{
    //地图的宽
    static int MAP_W=36;
    //地图的高
    static int MAP_H=17;
    //雷区偏移量
    static int OFFSET=45;
    //格子边长
    static int SQUARE_LENGTH=50;

    //鼠标相关
    static  int MOUSE_X;
    static  int MOUSE_Y;

    //游戏状态 0表示游戏中      1表示失败    2表示成功   3难度选择
    static  int state=3;
    //插旗数量
    static  int FLAG_NUM=0;

    //地雷个数
    static int RAY_MAX=100;

    //倒计时
    static long START_TIME;
    static  long  END_TIME;

    //游戏难度
    static  int level;

        //状态        左键和右键
    static  boolean LEFT=false;
    static  boolean RIGHT=false;

    //底层元素      -1表示雷   0  空    1-8表示对应数字
    static int [][] DATA_BOTTOM=new int[MAP_W+2][MAP_W+2];

    //顶层元素      -1无覆盖   0 覆盖   1 插旗     2插错旗
    static int [][] DATA_TOP=new int[MAP_W+2][MAP_W+2];


    //载入图片      雷
    static Image lei=Toolkit.getDefaultToolkit().getImage("imgs/lei.jpg");

    //数字
    static  Image[] images=new Image[9];
    static
    {
        for (int i = 1; i <= 8; i++) {
            images[i]=Toolkit.getDefaultToolkit().getImage("imgs/"+i+".jpg");
        }
    }

    //顶部
    static Image top=Toolkit.getDefaultToolkit().getImage("imgs/top.jpg");
    //旗帜
    static Image flag=Toolkit.getDefaultToolkit().getImage("imgs/flag.jpg");
    //错旗
    static Image noflag=Toolkit.getDefaultToolkit().getImage("imgs/noflag.jpg");
    //进行中
    static Image face=Toolkit.getDefaultToolkit().getImage("imgs/ing.jpg");
    //胜利
    static Image win=Toolkit.getDefaultToolkit().getImage("imgs/win.jpg");
    //失败
    static Image over=Toolkit.getDefaultToolkit().getImage("imgs/defect.jpg");




    static  void drawWord(Graphics g,String s,int x,int y,int size,Color color)
    {
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(s,x,y);

    }

}
