import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame
{
    int wight=2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    int height=4*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;


    //创建一个画布
    Image offScreenImage=null;

    MapBottom mapBottom=new MapBottom();

    MapTop mapTop=new MapTop();

    GameSelect gameSelect=new GameSelect();
    //是否开始,f未开始,t开始
    boolean begin=false;
    void launch()
    {
        GameUtil.START_TIME=System.currentTimeMillis();
        this.setVisible(true);//设置窗口是否可见
        if(GameUtil.state==3)
        {
        this.setSize(500,500);
        }
        else
        {
            this.setSize(wight,height);//设置窗口大小
        }

        this.setLocationRelativeTo(null);//居中显示
        this.setTitle("MineClearance");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭方法


        //鼠标事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //点击笑脸重置游戏
                switch (GameUtil.state)
                {
                    case 0:
                        //鼠标左键被点击
                        if(e.getButton()==1)
                        {
                            //System.out.println(1);
                            GameUtil.MOUSE_X=e.getX();
                            GameUtil.MOUSE_Y=e.getY();
                            GameUtil.LEFT=true;
                        }
                        //鼠标右键被点击
                        if(e.getButton()==3)
                        {
                            //System.out.println(3);
                            GameUtil.MOUSE_X=e.getX();
                            GameUtil.MOUSE_Y=e.getY();
                            GameUtil.RIGHT=true;
                        }

                    case 1:

                    case 2:
                        if(e.getButton()==1)
                        {
                            if(e.getX()> GameUtil.OFFSET+ GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2)
                            &&e.getX()<GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*
                                    (GameUtil.MAP_W/2)+GameUtil.SQUARE_LENGTH
                            &&e.getY()>GameUtil.OFFSET
                            &&e.getY()<GameUtil.OFFSET+GameUtil.SQUARE_LENGTH)
                            {
                                mapBottom.reGame();
                                mapTop.reGame();
                                GameUtil.FLAG_NUM=0;
                                GameUtil.START_TIME=System.currentTimeMillis();
                                GameUtil.state=0;

                            }

                        }
                        if(e.getButton()==2)
                        {
                            //进入难度选择界面
                            GameUtil.state=3;
                            begin=true;
                        }
                        break;
                    case  3:
                        if(e.getButton()==1)
                        {
                            GameUtil.MOUSE_X=e.getX();
                            GameUtil.MOUSE_Y=e.getY();
                            GameUtil.LEFT=true;
                           begin= gameSelect.hard();
                        }
                      break;
                    default:
                }

            }
        });







        while (true)
        {
            repaint();
            begin();
            begin=false;
            try {
                //延迟
                Thread.sleep(40);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    void begin()
    {
        if(begin)
        {
            //载入游戏
            //释放状态
            begin=false;
            gameSelect.hard(GameUtil.level);
            //窗口关闭
            dispose();
            GameWin gameWin=new GameWin();
            //重置开始时间
            GameUtil.START_TIME=System.currentTimeMillis();
            GameUtil.FLAG_NUM=0;
            mapBottom.reGame();
            mapTop.reGame();
            gameWin.launch();
        }
    }


    @Override

    public  void paint(Graphics g) {
        if (GameUtil.state == 3) {
            g.setColor(Color.white);
            g.fillRect(0,0,500,500);
            gameSelect.paintSelf(g);
        } else {
            offScreenImage = this.createImage(wight, height);
            Graphics graphics = offScreenImage.getGraphics();
            //设置背景颜色
            graphics.setColor(Color.white);
            //填充整个画布
            graphics.fillRect(0, 0, wight, height);
            mapBottom.paintSelf(graphics);
            mapTop.paintSelf(graphics);
            g.drawImage(offScreenImage, 0, 0, null);
        }
    }
        public static void main (String[]args){
            GameWin gameWin = new GameWin();
            gameWin.launch();
        }

}
