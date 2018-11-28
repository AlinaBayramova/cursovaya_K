package com.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;


public class MainDlg {

    private JPanel Panel;
    private JButton btn;
    private JTextField textField1;
    private JLabel lbl_info;
    private JTextField textField2;
    private JLabel lb_info;
    private String p; //значение переменной

    private byte Mn_vo(Scanner sc, byte n){
        String cel;
        String tmp;
        String cifry[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        if (sc.hasNext()) {
            tmp = sc.next().toUpperCase();//tmp содержит First or Multy
                if (tmp.equals("FIRST") || tmp.equals("SECOND")) {
                    cel = sc.next();
                    //пока не встречен add продолжать гонять в цикле проверку на числа, выходим в проверку add multy
                    if (cel.contains(",")) {
                        try{
                         while (cel.contains(",")) {
                             cel = cel.replaceAll(",", " ");
                             String digital[] = cel.split(" ");
                             int tmp_i;
                             //проверка на подряд идущие запятые
                             for (int i = 0; i < digital.length; i++) {
                                 if (digital[i].equals("")){
                                     JOptionPane.showMessageDialog(null, "Ожидались шестнадцатеричные числа через запятую");
                                     n++;
                                     return n;
                                 }
                             }
                             for (String aDigital : digital) {
                                 tmp_i = 0;
                                 for (String aCifry : cifry) {
                                     if (aDigital.equals(aCifry)) {
                                         tmp_i++;
                                         break;
                                     }
                                 }
                                 //если введеное число не совпрало ни с одним из массива допустимых цифр, то выводим сообщение об ошибке
                                 if (tmp_i == 0) {
                                     JOptionPane.showMessageDialog(null, "Ожидались шестнадцатеричные числа через запятую");
                                     n++;
                                     return n;
                                 }
                             }
                             try {
                                 cel = sc.next();
                                 cel = cel.replaceAll(" ", "");
                             } catch (Exception ex){
                                 JOptionPane.showMessageDialog(null, "Ожидалось слово Add or Multy");
                                 n++;
                                 return n;
                             }
                         }
                        }catch (Exception ex){
                            System.out.println("EBug?");
                            System.exit(9);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Ожидались целые через запятую");
                        n++;
                        return n;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ожидалось слово First or Second");
                    n++;
                    return n;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ожидалось второе слово First или Second");
                n++;
                return n;
            }
        //Блок ADD MulTY
        if (!cel.isEmpty()) {
            cel = cel.toUpperCase();
            if (cel.equals("ADD") || cel.equals("MULTY")) {
                try {
                    tmp = sc.next();
                    if (tmp.contains(",") || tmp.contains(".")) {
                        try{
                            Double is_double = Double.parseDouble(tmp);
                            if (!is_double.isNaN())  {
                                return 0;
                            } else {
                                JOptionPane.showMessageDialog(null, "Ожидалось вещ = циф . циф!");
                                n++;
                                return n;
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ожидалось вещ = циф . циф!");
                            n++;
                            return n;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Обнаружено целое число, а нужно вещ!");
                        n++;
                        return n;
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Ожидалось вещественное число или ENd!");
                    n++;
                    return n;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ожидалось слово Add or Multy");
                n++;
                return n;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ожидалось слово Add или Multy");
            n++;
            return n;
        }
        //return 0;
    }

    private byte Meth(Scanner scanner, byte n){
        Integer is_int;
        String slovo1;
        if (scanner.hasNext()) {
            slovo1 = scanner.next();
            try{
                //если нет метки, то проверяем на принадлежность переменной
                //todo поменять условие цикла
                while (scanner.hasNext()) {
                    if(slovo1.contains(",")){
                        JOptionPane.showMessageDialog(null, "Метка должна быть целочисленная!");
                        n++;
                        return n;
                    }
                    if (slovo1.contains(":")) {
                    slovo1 = slovo1.replace(":", "");
                    is_int = Integer.parseInt(slovo1); //если метка не целочисленная, то переходим в блок catch
                    slovo1 = scanner.next();
                        break;
                    } else {
                        is_int = Integer.parseInt(slovo1); //если метка не целочисленная, то переходим в блок catch
                        JOptionPane.showMessageDialog(null, "Ожидался ':' ");
                        n++;
                        return n;
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ожидалась метка");
                n++;
                return n;
            }
            if (slovo1.toUpperCase().equals(p)) {
                return 0;
            } else {
                JOptionPane.showMessageDialog(null, "Ожидался оператор!");
                n++;
                return n;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ожидалась метка или переменная");
            n++;
            return n;
        }

    }

    private byte Perem(Scanner sc, byte n){
        char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M', 'N', 'P', 'T', 'R', 'S', 'Q', 'W', 'Y', 'U', 'O', 'K', 'J', 'V', 'Z', 'X'};
        //проверяем переменную на соответсвтвеие алфавиту
            try {
                //String perem = sc.next();
                char [] tmp_p = p.toCharArray();

                for (char aTmp_p : tmp_p) {
                    int it = 0;
                    for (char anAlphabet : alphabet) {
                        if (aTmp_p == anAlphabet) {
                            it++;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Переменная может содержать символы только английского алфавита!");
                            n++;
                            return n;
                        }
                    }


                }

            } catch (Exception ex){

            }


        return 0;
    }


    public MainDlg() {
        lbl_info.setText("Введите переменную:");
        lb_info.setText("Вводите выражение: ");
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                byte n = 0;
                Scanner perem = new Scanner(textField2.getText().toUpperCase());
                Scanner scan = new Scanner(textField1.getText()); //считывам построчно
                try {//todo убрать блок try
                    if (scan.hasNextLine() && perem.hasNext()) {
                        String begin = scan.next().toUpperCase();
                        p = perem.next();
                        System.out.println();
                        if (!(p.contains(",") || p.contains("_") || p.contains(":") || p.contains("<") || p.contains(">") || p.contains(".") || p.contains("-")
                        || p.contains("+") || p.contains("="))){
                            if (begin.equals("BEGIN")) {
                               n =  Mn_vo(scan, n); // передаем всю строку дальше во множество
                                //если блок множество обработался без ошибок, то идем длальше в блок меток
                               if (n == 0) {
                                   n =  Meth(scan,n);
                                   if (n == 0) {
                                       n = Perem(scan, n);
                                   } else {
                                       System.out.println("Программа завершила работу с кодом ошибки: "+ n++);
                                   }
                               } else {
                                   System.out.println("Программа завершила работу с кодом ошибки: "+ n++);
                               }
                            } else {
                                JOptionPane.showMessageDialog(null, "Язык должен начинаться со слова Begin");
                                System.out.println("Программа завершила работу с кодом ошибки: "+ n++);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Неверный формат переменной");
                            System.out.println("Программа завершила работу с кодом ошибки: "+ n++);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Найдена пустая строка!");
                        System.out.println("Строка не найдена");
                        n++;
                        System.exit(n);
                    }
                } catch (Exception ex){
                    System.out.println("Встретился знак конца строки!");
                    n++;
                    System.exit(n);
                }
                scan.close();
            }
        });
    }

    public static void main(String[] arg) {
        JFrame frame  = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MainDlg().Panel);
        frame.setPreferredSize(new Dimension(300,200));
        frame.pack();
        frame.setVisible(true);

        //todo проверить на begin second 4,A,B multy 3.4 2:4: Par11 = - отработает, а не должно :((


    }
}
