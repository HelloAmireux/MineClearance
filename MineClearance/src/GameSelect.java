import java.awt.*;

import static java.awt.Color.black;

/*
*
* 难度选择
* */
public class GameSelect
{
    boolean hard()
    {
        //判断是否点击到难度
        if(GameUtil.MOUSE_X>100&& GameUtil.MOUSE_X<400)
        {
            if(GameUtil.MOUSE_Y>50&& GameUtil.MOUSE_Y<150)
            {
                GameUtil.level=1;
                GameUtil.state=0;
                return  true;
            }
            if(GameUtil.MOUSE_Y>200&& GameUtil.MOUSE_Y<300)
            {
                GameUtil.level=2;
                GameUtil.state=0;
                return  true;
            }
            if(GameUtil.MOUSE_Y>350&& GameUtil.MOUSE_Y<450)
        {
            GameUtil.level=3;
            GameUtil.state=0;
            return  true;
        }

        }
        return false;
    }
void paintSelf(Graphics g)
{
    g.setColor(Color.black);
    g.drawRect(100,50,300,100);
    GameUtil.drawWord(g,"easy",220,100,30, Color.black);
    g.drawRect(100,200,300,100);
    GameUtil.drawWord(g,"media",220,250,30, Color.black);
    g.drawRect(100,350,300,100);
    GameUtil.drawWord(g,"hard",220,400,30, Color.black);
}

void hard(int level)
{
    switch (level)
    {
        case 1:
            GameUtil.RAY_MAX=10;
            GameUtil.MAP_W=9;
            GameUtil.MAP_H=9;
            break;
        case 2:
            GameUtil.RAY_MAX=40;
            GameUtil.MAP_W=16;
            GameUtil.MAP_H=16;
            break;
        case 3:
            GameUtil.RAY_MAX=99;
            GameUtil.MAP_W=30;
            GameUtil.MAP_H=16;
            break;
        default:
    }
}


}


