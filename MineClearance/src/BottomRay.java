/*
*
*
* 初始化地雷
*
* */

public class BottomRay
{

    //存放坐标
  static   int []rays=new int[GameUtil.RAY_MAX*2];
    //地雷坐标
    int x,y;
    //是否可以放置地雷
    boolean isPlace=true;

    //生成雷
    void newRay()
    {

        for(int i=0;i<2*GameUtil.RAY_MAX;i+=2)
        {
            x=(int)(Math.random()*GameUtil.MAP_W+1);
            //+1的原因是让随机数从1-12
            y=(int)(Math.random()*GameUtil.MAP_H+1);
            //1-12
            rays[i]=x;
            rays[i+1]=y;
            //解决地雷重复的问题
            //判断坐标是否存在
            for(int j=0;j<i;j+=2)
            {
                if(x==rays[j]&&y==rays[j+1])
                {
                    i=i-2;
                    isPlace=false;
                    break;
                }
            }
            if(isPlace)
            {
                rays[i]=x;
                rays[i+1]=y;
            }
            //释放状态
            isPlace=true;
        }

        for(int i=0;i<GameUtil.RAY_MAX*2;i=i+2)
        {
            //变为雷
            GameUtil.DATA_BOTTOM[rays[i]][rays[i+1]]=-1;
        }

    }
}
