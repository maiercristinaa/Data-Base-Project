package controllers;

import org.apache.log4j.BasicConfigurator;
import views.QueryRequestView;

import java.util.List;

public class MainController {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        new QueryController(new QueryRequestView());
    }
}
