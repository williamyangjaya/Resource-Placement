/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.entities.Clients;
import com.mii.finalproject.entities.Employees;
import com.mii.finalproject.entities.Interviews;
import com.mii.finalproject.repositories.ClientsRepository;
import com.mii.finalproject.repositories.EmployeesRepository;
import java.text.SimpleDateFormat;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Locale;

/**
 *
 * @author William Yangjaya
 */
@Service
public class NotificationsService {

    JavaMailSender javaMailSender;

    EmployeesRepository employeesRepository;
    ClientsRepository clientsRepository;

    @Value("${spring.mail.username}")
    String sender;

    @Autowired
    public NotificationsService(JavaMailSender javaMailSender, EmployeesRepository employeesRepository, ClientsRepository clientsRepository) {
        this.javaMailSender = javaMailSender;
        this.employeesRepository = employeesRepository;
        this.clientsRepository = clientsRepository;
    }

    public void sendEmail(Interviews interviews) throws MessagingException {
        Employees employees = employeesRepository.findById(interviews.getEmpId().getEmpId()).get();
        Clients clients = clientsRepository.findById(interviews.getClientId().getClientId()).get();

        Locale id = new Locale("in", "ID");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE/dd MMMM yyyy", id);
        String strDate = sdf.format(interviews.getInterviewDate());

        SimpleDateFormat app = new SimpleDateFormat("HH.mm aa", id);
        String strTime = app.format(interviews.getInterviewDate());

        String via = interviews.getInterviewVia();

        String note = interviews.getNote();

        String location = interviews.getClientId().getLocation();

        String who = interviews.getClientId().getClientName();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(sender);
        helper.setTo(employees.getEmail());
        helper.setSubject("Interview Technical Invitation");

        message.setText(
                String.format("<b>Dear %s,</b>"
                        + "<br>"
                        + "<br>"
                        + "<br>"
                        + "Mohon kehadirannya untuk menghadiri undangan teknikal test dan interview yang akan dilaksanakan pada :"
                        + "<br>"
                        + "<br>"
                        + "Hari / Tanggal&nbsp;&nbsp;&nbsp;&nbsp;: <b>%s</b>"
                        + "<br>"
                        + "<br>"
                        + "Jam&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <b>%s</b>"
                        + "<br>"
                        + "<br>"
                        + "Via&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <b>%s</b>"
                        + "<br>"
                        + "<br>"
                        + "note&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <b>%s</b>"
                        + "<br>"
                        + "<br>"
                        + "Lokasi&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <b>%s</b>"
                        + "<br>"
                        + "<br>"
                        + "Up&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: %s"
                        + ""
                        + "<br>"
                        + "<br>"
                        + "Mohon untuk sudah <b>standby 10 menit sebelum</b> dilaksanakan dan melakukan <b>konfirmasi kehadiran</b> Anda dengan <i>accept invitation</i> ini."
                        + "<br><br>"
                        + "Terima kasih"
                        + "<br>"
                        + "<br>"
                        + "<br>"
                        + "<span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#2e74b5\">Salam sukses bahagia,<u></u><u></u></span>"
                        + "<br>"
                        + "<br>"
                        + "<br>"
                        + "<b><u><span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#2e74b5\">Adella Putri Christian Lay</span></u></b>"
                        + "<br>"
                        + "<br>"
                        + "<b><span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#2e74b5\">PT. Mitra Integrasi Informatika<u></u><u></u></span></b>"
                        + "<br>"
                        + "<br>"
                        + "<b><span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#2e74b5\">Talent Acquisition Specialist<u></u><u></u></span></b>"
                        + "<br>"
                        + "<br>"
                        + "<b><span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#4472c4\">HP. 62-821-3656-3699<u></u><u></u></span></b>"
                        + "<br>"
                        + "<br>"
                        + "<b><span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#4472c4\">APL Tower, 37<sup>th</sup> Floor<u></u><u></u></span></b>"
                        + "<br>"
                        + "<br>"
                        + "<b><span style=\"font-size:10.0pt;font-family:&quot;Garamond&quot;,serif;color:#4472c4\">Jl. Letjen S. Parman Kav. 28 Jakarta 11470</span></b>"
                        + "<br>"
                        + "<br>"
                        + "<br>"
                        + "<b><i><span style=\"font-size:9.0pt;font-family:&quot;Berlin Sans FB Demi,sans-serif&quot;,serif;color:#0070c0;\">“Together We Work, Grow, and Impactful”</span></i><b>"
                        + "<br>"
                        + "<br>"
                        + "<br>"
                        + "<hr>"
                        + "<br>"
                        + "<span style=\"font-size:18.0pt;font-family:&quot;Segoe UI&quot;,sans-serif;color:#252424\">Microsoft Teams meeting</span>"
                        + "<br>"
                        + "<br>"
                        + "<b>Join on your computer or mobile app</b>"
                        + "<br>"
                        + "<br>"
                        + "<u><a href=https://teams.microsoft.com/><span style=\"font-size:10.5pt;font-family:&quot;Segoe UI Semibold&quot;,sans-serif;color:#6264a7\">Click\n"
                        + " here to join the meeting</span></a></u>"
                        + "<br>"
                        + "<br>"
                        + "<u><a href=https://www.metrodataacademy.id/><span style=\"font-size:10.5pt;color:#6264a7\">Learn More</span></a></u>"
                        + " | "
                        + "<u><a href=https://www.metrodataacademy.id/><span style=\"font-size:10.5pt;color:#6264a7\">Meeting options</span></a></u>"
                        + "<br>"
                        + "<br>"
                        + "<br>"
                        + "<hr>"
                        + "", employees.getName(), strDate, strTime, via, note, clients.getLocation(), clients.getClientName()),
                "UTF-8", "html"
        );

        javaMailSender.send(message);
    }
}
