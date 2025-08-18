package com.msb.test14;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while(true){
            System.out.println("***欢迎来到老马书城***");
            System.out.println("项目功能：");
            System.out.println("1.展示书籍");
            System.out.println("2.上架书籍");
            System.out.println("3.下架书籍");
            System.out.println("4.更换书籍");
            System.out.println("5.查找书籍");
            System.out.println("6.退出应用");

            System.out.println("请输入您想执行的项目序号：");

            //从键盘读取数字
            Scanner sc=new Scanner(System.in);
            int Num=sc.nextInt();

            //根据用户输入的数字执行适配的功能
            if(Num==1){
                //提示词
                System.out.println("【老马书城】》》》展示书籍");

                //文件
                File f =new File("d:\\demo.txt");

               if(f.exists()){
                   //如果文件存在
                   //流
                   FileInputStream fis=new FileInputStream(f);
                   ObjectInputStream ois=new ObjectInputStream(fis);

                   //读取
                   ArrayList list=(ArrayList)ois.readObject();


                   for(int i=0;i<list.size();i++){
                       Book book = (Book) (list.get(i));
                       System.out.println(book.getNo()+"   "+book.getName()+"   "+book.getAuthor());
                   }
               }else{
                   //如果文件不存在
                   System.out.println("暂未上架过书籍，请选择\"2\"添加书籍。");
               }

            }
            if(Num==2){
                //提示词
                System.out.println("【老马书城】》》》上架书籍");
                System.out.println("请输入您想添加的书籍信息");
                System.out.println("书籍编号：");
                //从键盘读取书籍编号
                int No=sc.nextInt();

                //提示词
                System.out.println("书籍名字：");
                //从键盘读取书籍名字
                String Name=sc.next();

                //提示词
                System.out.println("书籍作者：");
                //从键盘读取书籍作者
                String Author=sc.next();

                //new一个Book类对象
                Book book=new Book();

                //上架
                book.setNo(No);
                book.setName(Name);
                book.setAuthor(Author);

                //文件
                File f = new File("d:\\demo.txt");

                if(f.exists()){
                    //如果文件存在，说明已添加过书籍
                    //流
                    FileInputStream fis=new FileInputStream(f);
                    ObjectInputStream ois=new ObjectInputStream(fis);

                    //读取
                    ArrayList list=(ArrayList)ois.readObject();
                    //添加
                    list.add(book);

                    //流
                    FileOutputStream fos=new FileOutputStream(f);
                    ObjectOutputStream oos=new ObjectOutputStream(fos);

                    //输出
                    oos.writeObject(list);

                    //关闭流
                    oos.close();
                    fos.close();
                }else{
                    //如果文件不存在
                    //创建一个集合，用于放置相同个体>>>一本书籍对象
                    ArrayList list=new ArrayList();

                    //把该书籍添加到list集合里
                    list.add(book);

                    //流
                    FileOutputStream fos=new FileOutputStream(f);
                    ObjectOutputStream oos=new ObjectOutputStream(fos);

                    //输出
                    oos.writeObject(list);

                    //关闭流
                    oos.close();
                    fos.close();
                }
            }
            if(Num==3){
                //提示词
                System.out.println("【老马书城】》》》下架书籍");
                System.out.println("请输入您要下架的书籍编号：");
                int delNo=sc.nextInt();

                //文件
                File f=new File("d:\\demo.txt");

                //流
                FileInputStream fis=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fis);

                ArrayList list=(ArrayList)ois.readObject();
                //遍历直到找到该序号所对应的书籍对象
                for(int i=0;i<list.size();i++){
                    Book book=(Book)(list.get(i));
                    if(book.getNo()==delNo){
                        //删除
                        list.remove(i);
                    }
                }
                //流
                FileOutputStream fos=new FileOutputStream(f);
                ObjectOutputStream oos=new ObjectOutputStream(fos);

                //输出
                oos.writeObject(list);

                //关闭流
                oos.close();
                fos.close();
            }
            if(Num==4){
                //提示词
                System.out.println("【老马书城】》》》更换书籍");
                System.out.println(("请输入您要更换的书籍编号："));
                //从键盘读取书籍编号
                int No=sc.nextInt();
                System.out.println("请输入新书籍名字：");
                String Name=sc.next();
                System.out.println("请输入新书籍作者：");
                String Author=sc.next();

                //文件
                File f =new File("d:\\demo.txt");

                //流
                FileInputStream fis=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fis);
                ArrayList list=(ArrayList)ois.readObject();
                for(int i=0;i<list.size();i++){
                    Book book=(Book)(list.get(i));
                    //找到对应编号的书籍
                    if(book.getNo()==No){
                        book.setName(Name);
                        book.setAuthor(Author);
                    }
                }
                //流
                FileOutputStream fos=new FileOutputStream(f);
                ObjectOutputStream oos=new ObjectOutputStream(fos);

                //输出
                oos.writeObject(list);

                //关闭流
                oos.close();
                fos.close();
            }
            if(Num==5){
                //提示词
                System.out.println("【老马书城】》》》查找书籍");
                System.out.println(("请输入您要查找的书籍编号："));
                //从键盘读取书籍编号
                int No=sc.nextInt();

                //文件
                File f=new File("d:\\demo.txt");

                //流
                FileInputStream fis=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fis);

                //输入
                ArrayList list=(ArrayList)ois.readObject();
                for(int i=0;i<list.size();i++){
                    Book book=(Book)(list.get(i));
                    //找到对应编号的书籍
                    if(book.getNo()==No){
                        System.out.println(book.getNo()+"   "+book.getName()+"   "+book.getAuthor());
                    }
                }
            }
            if(Num==6){
                //提示词
                System.out.println("【老马书城】》》》退出应用");
                break;
            }
        }

    }
}
