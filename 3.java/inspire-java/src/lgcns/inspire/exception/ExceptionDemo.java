package lgcns.inspire.exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class ExceptionDemo {

    public void printAry(String[] ary) {
        System.out.println(">>> ary print start");

        try {
            for (int i = 0; i <= ary.length; ++i) {
                System.out.println(ary[i]);
            }
            System.out.println(">> inner try");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println(">>> lets go everytime~");
        }

        System.out.println(">>> ary print end");
    }

    public String readConsole() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("input data : ");
        String data = "";
        try {
            data = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void first(int x) {
        System.out.println(">>> first start");
        second(x);
        System.out.println(">>> first end");
    }

    public void second(int x) {
        System.out.println(">>> second start");
        try {
            third(x);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(">>> second end");

    }

    public void third(int x) throws Exception {
        System.out.println(">>> third start");
        try {
            if (x < 0) {
                throw new Exception("please enter a positive number");
            }
        } finally {
            System.out.println(">>> third end");
        }

    }
}
