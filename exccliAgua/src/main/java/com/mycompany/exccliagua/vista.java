package com.mycompany.exccliagua;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author SamuelMS
 */
public class vista {

    private controlador controlador;

    vista(controlador controlador) {
        this.controlador = controlador;
    }

    public void convertir(String[] args) {

        Options options = new Options();
        
       
        Option oSubir = Option.builder("a").longOpt("aumentar").
                hasArg().desc("Aumenta los grados del agua").build();
        Option oBajar = Option.builder("b").longOpt("disminuir").
                hasArg().desc("Disminuye los grados del agua").build();

        OptionGroup group = new OptionGroup();
        group.addOption(oSubir);
        group.addOption(oBajar);
        options.addOptionGroup(group);
        options.addOption("h", "help", false,
                "muestra la ayuda");

        
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            } else {
                if (cmd.hasOption("a")) {
                    controlador.masGrados
        (Integer.parseInt(cmd.getOptionValue("a")));
                } else if (cmd.hasOption("b")) {
                    controlador.menosGrados(
                            Integer.parseInt(cmd.getOptionValue("b")));
                } else {
                    controlador.grados();
                }

            }

        } catch (ParseException ex) {
            System.err.println(ex.getLocalizedMessage());

        }
    }

    public void showT(int temp) {
        if (temp > 100) {
            System.out.println("La temperatura del agua es  " + temp +
                    "º  Error, has hervido el agua a más de 100º");

        } else if (temp < 0) {
            System.out.println("La temperatura del agua es  " + temp +
                    "º  Error, has congelado el agua");
        } else {
            System.out.println("El agua está a " + temp + "º");
        }

    }

}