import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Game{
    public static void main(String[] args){
        System.out.println("Name: Akshat Jain");
        System.out.println("Enrollment Number: Akshat Jain");
        System.out.println("Enter Buyers Details: ");
        String nam;
        long MobNo;
        System.out.println("Enter your Name: ");
        Scanner sc = new Scanner(System.in);
        nam = sc.nextLine();
        System.out.println("Enter your mobile number: ");
        MobNo = sc.nextLong();
        String ordr = "";
        int bill = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        while(true){
            while (true){
                int s;
                System.out.println("Select the seller: ");
                System.out.println("1. Lootera Tuck shop");
                System.out.println("2. Chaggan Halwai");
                System.out.println("3. Beswad Fastfoods");
                System.out.println("4. Exit");
                s = sc.nextInt();

                if(s==1){
                    int itm1;
                    System.out.println("Select the product you want to buy: ");
                    System.out.println("1. Cold Drink");
                    System.out.println("2. Chips");
                    System.out.println("3. Candies");
                    System.out.println("4. Milk");
                    System.out.println("5. Exit");
                    itm1 = sc.nextInt();
                    if(itm1 == 1){
                        System.out.println("Cold Drink Added to cart");
                        ordr += "Cold Drink, ";
                        bill += 30;
                    }
                    else if(itm1 == 2){
                        System.out.println("Chips Added to cart");
                        ordr += "Chips, ";
                        bill += 20;
                    }
                    else if(itm1 == 3){
                        System.out.println("Candies Added to cart");
                        ordr += "Candies, ";
                        bill += 10;
                    }
                    else if(itm1 == 4){
                        System.out.println("Milk Added to cart");
                        ordr += "Milk, ";
                        bill += 40;
                    }
                    else if(itm1 == 5){
                        break;
                    }
                    else{
                        System.out.println("Try Again");
                    }
                }


                else if(s==2){
                    int itm2;
                    System.out.println("Select the product you want to buy: ");
                    System.out.println("1. Gulab Jamun");
                    System.out.println("2. Rasgulla");
                    System.out.println("3. Rasmalai");
                    System.out.println("4. Barfi");
                    System.out.println("s. Exit");
                    itm2 = sc.nextInt();
                    if(itm2 == 1){
                        System.out.println("Gulab Jamun Added to cart");
                        ordr += "Gulab Jamun, ";
                        bill += 120;
                    }
                    else if(itm2 == 2){
                        System.out.println("Rasgulla Added to cart");
                        ordr += "Rasgulla, ";
                        bill += 220;
                    }
                    else if(itm2 == 3){
                        System.out.println("Rasmalai Added to cart");
                        ordr += "Rasmalai, ";
                        bill += 150;
                    }
                    else if(itm2 == 4){
                        System.out.println("Barfi Added to cart");
                        ordr += "Barfi, ";
                        bill += 320;
                    }
                    else if(itm2 == 5){
                        break;
                    }
                    else{
                        System.out.println("Try Again");
                    }
                }

                else if(s==3){
                    int itm3;
                    System.out.println("Select the product you want to buy: ");
                    System.out.println("1. Pizza");
                    System.out.println("2. Burger");
                    System.out.println("3. Pasta");
                    System.out.println("4. Noodles");
                    System.out.println("5. Exit");
                    itm3 = sc.nextInt();
                    if(itm3 == 1){
                        System.out.println("Pizza Added to cart");
                        ordr += "Pizza, ";
                        bill += 100;
                    }
                    else if(itm3 == 2){
                        System.out.println("Burger Added to cart");
                        ordr += "Burger, ";
                        bill += 80;
                    }
                    else if(itm3 == 3){
                        System.out.println("Pasta Added to cart");
                        ordr += "Pasta, ";
                        bill += 40;
                    }
                    else if(itm3 == 4){
                        System.out.println("Noodles Added to cart");
                        ordr += "Noodles, ";
                        bill += 50;
                    }
                    else if(itm3==5){
                        break;
                    }
                    else{
                        System.out.println("Try Again");
                    }

                }

                else if(s==4){
                    break;
                }

            }

            System.out.println("Name: " + nam);
            System.out.println("Mobile No: " + MobNo);
            System.out.println("Date: " + dtf.format(now));
            System.out.println( "Your Order is: ");
            System.out.println(ordr);
            System.out.println("Bill: " + bill);
            int cont;
            System.out.println("You want to continue shopping? ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            cont = sc.nextInt();
            if(cont==1){
                continue;
            }
            else{
                break;
            }
        }

    }
}