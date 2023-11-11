/*
*
* 底层地图
* 绘制游戏相关组件
* */

import java.awt.*;

public class MapBottom
{

    BottomRay bottomRay=new BottomRay();
    BottomNum bottomNum=new BottomNum();
    {
        bottomRay.newRay();
        bottomNum.newNum();
    }
    //重置游戏
    void reGame()
    {
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                GameUtil.DATA_BOTTOM[i][j]=0;
            }
        }
        bottomRay.newRay();
        bottomNum.newNum();
    }

    //绘制自己
    void paintSelf(Graphics g)
    {

        g.setColor(Color.red);
        //画竖线
        for (int i = 0; i <= GameUtil.MAP_W; i++) {
            g.drawLine(GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
                    3* GameUtil.OFFSET,
                    GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
                    3*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH
                    );
            //画横线
            for (int j = 0; j <=GameUtil.MAP_H; j++) {
               g.drawLine( GameUtil.OFFSET,
                       3*GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
                       GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH,
                       3*GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH);
            }
        }


        //贴图
        for (int i = 1; i <=GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                //雷
                if (GameUtil.DATA_BOTTOM[i][j] == -1) {
                    g.drawImage(GameUtil.lei,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,//这个是为了露出红线
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,//和上面同理
                            GameUtil.SQUARE_LENGTH - 2,//图片缩小两个像素
                            GameUtil.SQUARE_LENGTH - 2,//同理
                            null);
                }
                //数字
                if (GameUtil.DATA_BOTTOM[i][j] >=0) {
                    g.drawImage(GameUtil.images[GameUtil.DATA_BOTTOM[i][j] ],
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,//这个是为了露出红线
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,//和上面同理
                            GameUtil.SQUARE_LENGTH - 2,//图片缩小两个像素
                            GameUtil.SQUARE_LENGTH - 2,//同理
                            null);
                }
            }
        }


        //绘制数字,剩余雷数
        GameUtil.drawWord(g,"residue:"+(GameUtil.RAY_MAX- GameUtil.FLAG_NUM),
                GameUtil.OFFSET-40,
                GameUtil.OFFSET*2,30,Color.red);
        GameUtil.drawWord(g,"time:"+(GameUtil.END_TIME- GameUtil.START_TIME)/1000,
                GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*( GameUtil.MAP_W-1)-70,
                GameUtil.OFFSET*2,30,Color.red);


                switch (GameUtil.state)
            {
            case 0:
                //进行中
                GameUtil.END_TIME=System.currentTimeMillis();
                g.drawImage(GameUtil.face,
                        GameUtil.OFFSET+ GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        null);
                break;
            case  1:
                //赢了
                g.drawImage(GameUtil.win,
                        GameUtil.OFFSET+ GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        null);
                break;
            case 2:
                //失败
                g.drawImage(GameUtil.over,
                        GameUtil.OFFSET+ GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        null);
                break;
            default:

        }

    }

}
