package org.sendmail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.print("Sender Gmail id\t\t: ");
        String sender = sc.nextLine();
        System.out.print("Recipient Gmail id\t: ");
        String recipient = sc.nextLine();
        System.out.print("Subject\t\t\t\t: ");
        String subject = sc.nextLine();
        System.out.print("Brief message\t\t: ");
        String message = sc.nextLine();
        System.out.print("Verification Code\t: ");
        String twostepVerificationCode = sc.next();

        HandleMail mail = new HandleMail(sender, recipient, subject, message, twostepVerificationCode);
        mail.sendMail();
    }
}
