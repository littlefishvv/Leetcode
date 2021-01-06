package others.Exception;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/18 13:18
 * @description：
 * @modified By：
 * @version: $
 */
public class SimpleException extends Exception {
    public class Test{
        void cc() throws SimpleException{
            throw new SimpleException();
        }
        void cd(){
            try {
                cc();
            } catch (SimpleException e) {
                e.printStackTrace();
            }
        }
    }

}
