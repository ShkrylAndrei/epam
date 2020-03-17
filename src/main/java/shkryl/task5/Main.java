/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task5.filter.Filter;
import shkryl.task5.util.GenerateMainMenu;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Запуск программы");

        GenerateMainMenu.generate();


    }
}
