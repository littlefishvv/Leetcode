package others;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/5 16:35
 * @description：
 * @modified By：
 * @version: $
 */
public class Qiangke {


        public static void main(String[] args)
        {
            Qiangke test=new Qiangke();
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            for(int i=0;i<1;i++)
            {
                test.choose1();
            }
            //让程序进行40次的循环
            System.out.println("退出");
        }
        public void choose1()
        {
            try
            {
                Robot robot = new Robot();
                robot.delay(400);
                robot.mouseMove(50, 250);
                robot.mouseMove(50, 250);
                robot.mouseMove(50, 250);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);

                robot.delay(400);


                long t1 = System.currentTimeMillis();//获取当前时间
                while(true)
                {
                    long t2=System.currentTimeMillis();//再次获取当前时间
                    System.out.println("进去1");

                    robot.mouseMove(1000, 800);
                    robot.mouseMove(1000, 800);
                    robot.mouseMove(1000, 800);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.delay(20);
                    robot.mouseMove(3000, 633);
                    robot.mouseMove(3000, 633);
                    robot.mouseMove(3000, 633);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.delay(20);

                    if(t2-t1>3000)
                    {
                        break;
                    }
                }
            } catch (AWTException e)
            {
                e.printStackTrace();
            }
        }


}
