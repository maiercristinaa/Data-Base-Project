package controllers;

import database.QueryDB;
import models.QueryModel;
import models.QueryRequestModel;
import views.QueryRequestView;
import views.QueryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryController {
    private final QueryRequestView view;

    public QueryController(QueryRequestView view) {
        this.view = view;
        setActionListeners();
    }

    private void setActionListeners() {
        view.setButtonViewQuery1ActionListener(new Query1ActionListener(view));
        view.setButtonViewQuery2ActionListener(new Query2ActionListener(view));
        view.setButtonViewQuery3ActionListener(new Query3ActionListener(view));
        view.setButtonViewQuery4ActionListener(new Query4ActionListener());
        view.setButtonViewQuery5ActionListener(new Query5ActionListener(view));
        view.setButtonViewQuery6ActionListener(new Query6ActionListener());
        view.setButtonViewQuery7ActionListener(new Query7ActionListener());
        view.setButtonViewQuery8ActionListener(new Query8ActionListener());
    }


    private record Query1ActionListener(QueryRequestView view) implements ActionListener {
        private static final String queryString =
                "call numberOfBooksWithAGivenGenreWithNumberOfPagesBetweenAGivenRange(?,?,?)";
        private static final String parameter1 = "genre";
        private static final String parameter2 = "min_number_of_pages";
        private static final String parameter3 = "max_number_of_pages";

        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> parameterNames = new ArrayList<>();
            List<String> parameterValues = new ArrayList<>();

            parameterNames.add(parameter1);
            parameterNames.add(parameter2);
            parameterNames.add(parameter3);

            parameterValues.add(view.getHintTextFieldGenreQuery1());
            parameterValues.add(view.getHintTextFieldMinPagesQuery1());
            parameterValues.add(view.getHintTextFieldMaxPagesQuery1());

            QueryRequestModel requestModel = new QueryRequestModel(queryString, parameterNames, parameterValues);
            QueryDB queryDB = QueryDB.getInstance();
            try {
                QueryModel model = queryDB.executeQuery(requestModel);
                new QueryView(model);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    private record Query2ActionListener(QueryRequestView view) implements ActionListener {
        private static final String queryString = "call notReturnedBooksWithAGivenOverdue(?)";
        private static final String parameter1 = "overdue";

        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> parameterNames = new ArrayList<>();
            List<String> parameterValues = new ArrayList<>();

            parameterNames.add(parameter1);
            parameterValues.add(view.getHintTextFieldOverdueQuery2());

            QueryRequestModel requestModel = new QueryRequestModel(queryString, parameterNames, parameterValues);
            QueryDB queryDB = QueryDB.getInstance();
            try {
                QueryModel model = queryDB.executeQuery(requestModel);
                new QueryView(model);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private record Query3ActionListener(QueryRequestView view) implements ActionListener {
        private static final String queryString = "call booksBorrowedFromAGivenGenreInTheLastGivenDays(?,?)";
        private static final String parameter1 = "genre";
        private static final String parameter2 = "number_of_days";

        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> parameterNames = new ArrayList<>();
            List<String> parameterValues = new ArrayList<>();

            parameterNames.add(parameter1);
            parameterNames.add(parameter2);

            parameterValues.add(view.getHintTextFieldGenreQuery3());
            parameterValues.add(view.getHintTextFieldNumberOfDaysQuery3());

            QueryRequestModel requestModel = new QueryRequestModel(queryString, parameterNames, parameterValues);
            QueryDB queryDB = QueryDB.getInstance();
            try {
                QueryModel model = queryDB.executeQuery(requestModel);
                new QueryView(model);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static final class Query4ActionListener implements ActionListener {
        private static final String queryString = "call getMultipleAuthors()";

        public static void prepareStatement(String queryString) {
            QueryRequestModel requestModel = new QueryRequestModel(queryString, new ArrayList<>(), new ArrayList<>());
            QueryDB queryDB = QueryDB.getInstance();
            try {
                QueryModel model = queryDB.executeQuery(requestModel);
                new QueryView(model);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            prepareStatement(queryString);
        }
    }

    private record Query5ActionListener(QueryRequestView view) implements ActionListener {

        private static final String queryString = "call getBooksWithTitleContainingGivenKeyword(?)";
        private static final String parameter1 = "keyword";

        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> parameterNames = new ArrayList<>();
            List<String> parameterValues = new ArrayList<>();

            parameterNames.add(parameter1);
            parameterValues.add(view.getHintTextFieldKeywordQuery5());

            QueryRequestModel requestModel = new QueryRequestModel(queryString, parameterNames, parameterValues);
            QueryDB queryDB = QueryDB.getInstance();
            try {
                QueryModel model = queryDB.executeQuery(requestModel);
                new QueryView(model);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static final class Query6ActionListener implements ActionListener {
        private static final String queryString = "call getTitleAndAuthorsThatHaveMaximumNumberOfCopies()";

        @Override
        public void actionPerformed(ActionEvent e) {
            Query4ActionListener.prepareStatement(queryString);
        }
    }

    private static final class Query7ActionListener implements ActionListener {
        private static final String queryString = "call getPersonsNameForTheHighestOverdue()";

        @Override
        public void actionPerformed(ActionEvent e) {
            Query4ActionListener.prepareStatement(queryString);
        }
    }

    private static final class Query8ActionListener implements ActionListener {
        private static final String queryString = "call getMinimumAverageAndMaximumNumberOfPagesForEachGenre()";

        @Override
        public void actionPerformed(ActionEvent e) {
            Query4ActionListener.prepareStatement(queryString);
        }
    }
}
