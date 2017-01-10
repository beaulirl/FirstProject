package org.FirstProject.example.client;

import org.FirstProject.example.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.Timer;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

import java.util.ArrayList;


public class FirstProject implements EntryPoint {

    private Button sendButton = new Button();
    private TextBox nameField = new TextBox();
    private Label errorLabel = new Label();
    private FlexTable myFlexTable = new FlexTable();
    private ArrayList<String> names = new ArrayList<String>();
    private VerticalPanel mainPanel = new VerticalPanel();

    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private final Messages messages = GWT.create(Messages.class);

    public void onModuleLoad() {

        nameField.setText(messages.nameField());
        sendButton.setText(messages.sendButton());

        myFlexTable.setText(0, 0, "Name");
        myFlexTable.setText(0, 1, "Date");
        myFlexTable.setText(0, 2, "Remove");

        myFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        myFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
        myFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");

        mainPanel.add(myFlexTable);

        mainPanel.addStyleName("addPanel");

        RootPanel.get("table").add(mainPanel);

        sendButton.addStyleName("sendButton");

        RootPanel.get("nameFieldContainer").add(nameField);
        RootPanel.get("sendButtonContainer").add(sendButton);
        RootPanel.get("errorLabelContainer").add(errorLabel);

        nameField.setFocus(true);
        nameField.selectAll();

        class MyHandler implements ClickHandler {

            public void onClick(ClickEvent event) {
                addName();
            }

            private void addName() {

                final String symbol = nameField.getText().toUpperCase().trim();
                if (names.contains(symbol))
                    return;
                else {
                    int row = myFlexTable.getRowCount();
                    names.add(symbol);
                    DateTimeFormat dateFormat = DateTimeFormat.getFormat(
                            DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);

                    myFlexTable.setText(row, 0, symbol);
                    myFlexTable.setText(row, 1, dateFormat.format(new Date()));
                    Button removeStockButton = new Button("x");
                    removeStockButton.addStyleDependentName("remove");

                    removeStockButton.addClickHandler(new ClickHandler() {
                        public void onClick(ClickEvent event) {
                            int removedIndex = names.indexOf(symbol);
                            names.remove(removedIndex);
                            myFlexTable.removeRow(removedIndex + 1);
                        }
                    });

                    myFlexTable.setWidget(row, 2, removeStockButton);

                }
            }

        }

        MyHandler handler = new MyHandler();
        sendButton.addClickHandler(handler);
    }

}
