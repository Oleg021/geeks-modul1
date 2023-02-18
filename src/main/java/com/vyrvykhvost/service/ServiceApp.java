package com.vyrvykhvost.service;

import com.vyrvykhvost.ReaderTxt;
import com.vyrvykhvost.model.Souvenir;
import com.vyrvykhvost.repository.RepositoryApp;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;


public class ServiceApp {
    private static final Logger LOG = LogManager.getLogger(ServiceApp.class);
    private static final RepositoryApp REPOSITORY_APP = new RepositoryApp();
    private static final ReaderTxt READER_TXT = new ReaderTxt();
    List<Souvenir> list = new ArrayList<>();
    List<Souvenir> resultList = new ArrayList<>();
    List<Souvenir> souvenirs = new ArrayList<>();
    List<Souvenir> souvenirList = READER_TXT.takeSouvenirFromTxt("text.txt");
    Scanner scanner = new Scanner(System.in);

    public void addSouvenirToList() {
        list.add(Souvenir.convert(scanner.next()));
        resultList.addAll(souvenirList);
        resultList.addAll(list);
        for (Souvenir elem : resultList) {
            LOG.info(elem);
        }
    }


    public void souvenirFromManufacture() {
        LOG.info("Enter name of company");
        String manufactureName = scanner.nextLine();
        resultList = REPOSITORY_APP.getInfoSouvenir(souvenirList, manufactureName);
        for (Souvenir elem : resultList) {
            LOG.info(elem.toStringSouvenir());
        }
    }

    public void souvenirFromCounrty() {
        LOG.info("Enter name of country");
        String countryName = scanner.nextLine();
        resultList = REPOSITORY_APP.getInfSouvenirByCountry(souvenirList, countryName);
        for (Souvenir elem : resultList) {
            LOG.info(elem.toStringSouvenir());
        }
    }

    public void souvenirWhoPriceLess() {
        LOG.info("Enter price of souvenir");
        int price = scanner.nextInt();
        resultList = REPOSITORY_APP.getManufacturerByPrice(souvenirList, price);
        for (Souvenir elem : resultList) {
            LOG.info(elem);
        }
    }

    public void getInfAllCompany() {
        resultList = REPOSITORY_APP.getInfoManufacturer(souvenirList);
        for (Souvenir elem : resultList) {
            LOG.info(elem);
        }
    }

    public void getCompanyByYearAndSouvenir() {
        LOG.info("Enter year");
        int year = scanner.nextInt();
        LOG.info("Enter name of souvenir");
        String souvenir = scanner.nextLine();
        resultList = REPOSITORY_APP.getSouvenirByYear(souvenirList, year, souvenir);
        for (Souvenir elem : resultList) {
            LOG.info(elem);
        }
    }

    public void sortListByYear() {
        resultList = REPOSITORY_APP.sortByYear(souvenirList);
        for (Souvenir elem : resultList) {
            LOG.info(elem);
        }
    }

    public void deleteByManufacturer() {
        LOG.info("Enter name of company");
        String manufacture = scanner.nextLine();
        resultList = REPOSITORY_APP.remove(souvenirList, manufacture);
        for (Souvenir elem : resultList) {
            LOG.info(elem);
        }
    }

    public void readFromFile() {
        souvenirs = READER_TXT.takeSouvenirFromTxt("text.txt");
        souvenirList.addAll(souvenirs);
    }

    public void showList() {
        for (Souvenir elem : souvenirList) {
            LOG.info(elem);
        }
    }

    public void serviceMenu() {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            LOG.info(" Enter a number of operation: " +
                    "\n1 - Add new souvenir to list " +
                    "\n2 - Get information about souvenirs of a given manufacturer" +
                    "\n3 - Get information about souvenirs produced in a given country" +
                    "\n4 - Get information about manufacturers whose prices for souvenirs are less than a given one" +
                    "\n5 - Get information on all manufacturers and, for each manufacturer, " +
                    "display information about all the souvenirs that it produces." +
                    "\n6 - Get information about the manufacturers of a given souvenir produced in a given year" +
                    "\n7 - Sorted by year" +
                    "\n8 - Delete a souvenir by a given manufacturer" +
                    "\n9 - Read from file" +
                    "\n10 - Show list manufacturer and souvenir" +
                    "\n0 - Exit");
            input = scanner.nextInt();
            switch (input) {
                case (1):
                    addSouvenirToList();
                    break;
                case (2):
                    souvenirFromManufacture();
                    break;
                case (3):
                    souvenirFromCounrty();
                    break;
                case (4):
                    souvenirWhoPriceLess();
                    break;
                case (5):
                    getInfAllCompany();
                    break;
                case (6):
                    getCompanyByYearAndSouvenir();
                    break;
                case (7):
                    sortListByYear();
                    break;
                case (8):
                    deleteByManufacturer();
                    break;
                case (9):
                    readFromFile();
                    break;
                case (10):
                    showList();
                    break;
                case (0):
                    break;
            }

        } while (input != 0);
    }

}
