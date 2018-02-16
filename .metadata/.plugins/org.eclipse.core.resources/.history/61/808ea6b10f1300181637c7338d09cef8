package lab3;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import textproc.AlphabeticalComparator;
import textproc.GeneralWordCounter;
import textproc.WordCountComparator;

public class BookReaderController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();

		// =============TEXTINLÄSNING===================
		List<String> holgersson = new ArrayList<String>();
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (s.hasNext()) {
			holgersson.add(s.next().toLowerCase());
		}
		s.close();

		Scanner s2 = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while (s2.hasNext()) {
			stopwords.add(s2.next().toLowerCase());
		}
		s2.close();

		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);
		holgersson.forEach(word -> gwc.process(word));

		// ================LAYOUT====================
		ObservableList<Map.Entry<String, Integer>> words = FXCollections.observableArrayList(gwc.getWords());
		ListView<Map.Entry<String, Integer>> listView = new ListView<>(words);
		root.setCenter(listView);

		HBox hb = new HBox();
		Button bAlph = new Button("Alphabetic");
		Button bFreq = new Button("Frequency");
		Button bSearch = new Button("Search");

		TextField tSearch = new TextField();
		HBox.setHgrow(tSearch, Priority.ALWAYS);
		tSearch.setMaxWidth(Double.MAX_VALUE);

		hb.getChildren().addAll(bAlph, bFreq);
		hb.getChildren().add(tSearch);
		hb.getChildren().add(bSearch);

		root.setBottom(hb);

		// ============BUTTON FUNCTIONALITY===================
		bFreq.setOnAction(click -> words.sort(new WordCountComparator()));
//		bAlph.setOnAction(click -> words.sort(new AlphabeticalComparator()));
		bAlph.setOnAction(click -> words.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey())));
		

		root.addEventHandler(KeyEvent.KEY_PRESSED, search -> {
			if (search.getCode() == KeyCode.ENTER) {
				if (scene.focusOwnerProperty().get() instanceof Button) {
					Button focus = (Button) scene.focusOwnerProperty().get();
					focus.fire();
					search.consume();
				}
				if (scene.focusOwnerProperty().get().equals(tSearch)) {
					bSearch.fire();
					search.consume();
				}
			}
		});

		bSearch.setOnAction(click -> {
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).getKey().equals(tSearch.getText().trim().toLowerCase())) {
					listView.scrollTo(words.get(i));
					listView.getSelectionModel().select(words.get(i));
					break;
				} else if (i + 1 == words.size()) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Message");
					alert.setTitle("Information");
					alert.setContentText("The word " + tSearch.getText().trim() + " isn't in the list");
					alert.showAndWait();
				}
			}
		});

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
