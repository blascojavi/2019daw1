package Ejercicio1;

import org.omg.PortableServer.CurrentPackage.NoContextHelper;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Fechas {
    public static void main(String[] args) {
        LocalDateTime toDay = LocalDateTime.now();

        System.out.println("a) " + toDay.format(DateTimeFormatter.ofPattern("E', dia 'd' de 'M' de del año 'y' son las 'HH:mm ")));
        System.out.println("b) " + toDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("c) " + toDay.format(DateTimeFormatter.ISO_DATE));
        LocalDateTime moreDays  = toDay.plusDays(25);
        System.out.println("h) " + moreDays.format(DateTimeFormatter.ISO_DATE));
        LocalDateTime fiveDaysLeft = toDay.minusDays(5);
        System.out.println("i) " + fiveDaysLeft.format(DateTimeFormatter.ISO_DATE));
        LocalDate cremaFalles = LocalDate.of(2002,03,19);
        Period faltaParaCrema = Period.between(cremaFalles, LocalDate.from(toDay));

        System.out.println("Faltan " + faltaParaCrema.getDays() + " Para la crema de la falla");

        LocalDate nocheVieja = LocalDate.of(2020 , 12 , 31);

        Period hastaNochevieja = Period.between(nocheVieja ,  LocalDate.from(toDay));

        System.out.println(hastaNochevieja.getMonths());

    }

}
