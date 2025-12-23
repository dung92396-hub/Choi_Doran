package Netflix;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class NetflixApp extends Application {
    private final NetflixPlatform platform = new NetflixPlatform("Netflix");
    private final ObservableList<Film> filmData = FXCollections.observableArrayList();

    private ComboBox<Genre> genreFilter;
    private ComboBox<Country> countryFilter;
    private TextField minScoreFilter;
    private TextField searchText;

    private TextField codeInput;
    private TextField nameInput;
    private ComboBox<Genre> genreInput;
    private ComboBox<Country> countryInput;
    private Spinner<Double> starsInput;
    private Spinner<Double> scoreInput;
    private Spinner<Integer> ageInput;
    private DatePicker releaseInput;
    private TextField durationInput;

    // Color scheme
    private static final String DARK_BG = "#0a0e27";
    private static final String CARD_BG = "#1a1f3a";
    private static final String ACCENT_RED = "#e50914";
    private static final String ACCENT_ORANGE = "#ff6b35";
    private static final String TEXT_WHITE = "#ffffff";
    private static final String TEXT_GRAY = "#b0b0b0";
    private static final String BORDER_COLOR = "#2a3f5f";

    @Override
    public void start(Stage stage) {
        seedDemoData();
        filmData.setAll(platform.getFilms());

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: " + DARK_BG + ";");
        root.setPadding(Insets.EMPTY);

        root.setTop(buildHeader());
        root.setCenter(buildTable());
        root.setBottom(buildFooter());

        Scene scene = new Scene(root, 1400, 900);
        stage.setTitle("🎬 Netflix Platform Manager");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.show();
    }

    private VBox buildHeader() {
        VBox header = new VBox(12);
        header.setPadding(new Insets(25, 30, 15, 30));
        header.setStyle("-fx-background-color: linear-gradient(to right, " + ACCENT_RED + ", #1a1a2e); " +
                "-fx-border-color: " + ACCENT_RED + "; -fx-border-width: 0 0 3 0;");

        Label title = new Label("🎬 Netflix Platform Manager");
        title.setStyle("-fx-font-size: 36; -fx-font-weight: bold; -fx-text-fill: white; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 5, 0, 0, 1);");

        Label subtitle = new Label("📽️ Manage your film collection with advanced filtering and organization");
        subtitle.setStyle("-fx-font-size: 12; -fx-text-fill: #d0d0d0;");

        VBox titleBox = new VBox(5);
        titleBox.getChildren().addAll(title, subtitle);

        ToolBar filterBar = buildFilters();
        filterBar.setStyle("-fx-background-color: #1a1f3a; -fx-padding: 10px; " +
                "-fx-border-color: " + BORDER_COLOR + "; -fx-border-width: 0 0 1 0;");

        header.getChildren().addAll(titleBox, filterBar);
        return header;
    }

    private VBox buildFooter() {
        VBox footer = new VBox(12);
        footer.setPadding(new Insets(20, 30, 20, 30));
        footer.setStyle("-fx-background-color: " + CARD_BG + "; " +
                "-fx-border-color: " + ACCENT_RED + "; -fx-border-width: 2 0 0 0;");

        TitledPane addPane = new TitledPane("➕ Add New Movie", buildAddForm());
        addPane.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: " + TEXT_WHITE + ";");
        addPane.setCollapsible(true);
        addPane.setExpanded(false);
        addPane.setAnimated(true);

        footer.getChildren().add(addPane);
        return footer;
    }

    private TableView<Film> buildTable() {
        TableView<Film> tv = new TableView<>();
        tv.setItems(filmData);
        tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        tv.setStyle("-fx-control-inner-background: " + DARK_BG + "; " +
                "-fx-table-cell-border-color: " + BORDER_COLOR + "; " +
                "-fx-text-fill: " + TEXT_WHITE + "; -fx-font-size: 11; -fx-row-height: 38;");

        TableColumn<Film, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(param -> new ReadOnlyStringWrapper(
                (param.getValue() instanceof Series) ? "🎭 SERIES" : "🎬 MOVIE"));
        typeCol.setPrefWidth(90);

        TableColumn<Film, String> codeCol = new TableColumn<>("Code");
        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeCol.setPrefWidth(80);

        TableColumn<Film, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(240);

        TableColumn<Film, Genre> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        genreCol.setPrefWidth(130);

        TableColumn<Film, Country> countryCol = new TableColumn<>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryCol.setPrefWidth(110);

        TableColumn<Film, Double> starsCol = new TableColumn<>("⭐ Stars");
        starsCol.setCellValueFactory(new PropertyValueFactory<>("starRating"));
        starsCol.setPrefWidth(80);

        TableColumn<Film, Double> scoreCol = new TableColumn<>("📊 Score");
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score10"));
        scoreCol.setPrefWidth(80);

        TableColumn<Film, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("ageRequired"));
        ageCol.setPrefWidth(60);

        TableColumn<Film, LocalDate> releaseCol = new TableColumn<>("📅 Release");
        releaseCol.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        releaseCol.setPrefWidth(120);

        tv.getColumns().addAll(typeCol, codeCol, nameCol, genreCol, countryCol, starsCol, scoreCol, ageCol, releaseCol);

        // Custom row styling
        tv.setRowFactory(table -> new TableRow<Film>() {
            @Override
            protected void updateItem(Film item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getIndex() < 0) {
                    setStyle("");
                } else {
                    String bgColor = (getIndex() % 2 == 0) ? CARD_BG : "#242a47";
                    setStyle("-fx-background-color: " + bgColor + ";");
                    setOnMouseEntered(e -> setStyle("-fx-background-color: #2a3f5f;"));
                    setOnMouseExited(e -> setStyle("-fx-background-color: " + bgColor + ";"));
                }
            }
        });

        return tv;
    }

    private ToolBar buildFilters() {
        genreFilter = new ComboBox<>(FXCollections.observableArrayList(Genre.values()));
        genreFilter.setPromptText("📂 Genre");
        genreFilter.setPrefWidth(140);
        styleComboBox(genreFilter);

        countryFilter = new ComboBox<>(FXCollections.observableArrayList(Country.values()));
        countryFilter.setPromptText("🌍 Country");
        countryFilter.setPrefWidth(150);
        styleComboBox(countryFilter);

        minScoreFilter = new TextField();
        minScoreFilter.setPromptText("Min Score");
        minScoreFilter.setPrefWidth(110);
        styleTextField(minScoreFilter);

        searchText = new TextField();
        searchText.setPromptText("🔍 Search by name or code...");
        searchText.setStyle("-fx-control-inner-background: #1a1f3a; -fx-text-fill: " + TEXT_WHITE +
                "; -fx-font-size: 11; -fx-padding: 8; -fx-border-color: " + BORDER_COLOR + ";");
        HBox.setHgrow(searchText, Priority.ALWAYS);

        Button apply = new Button("🔍 Apply");
        apply.setStyle("-fx-font-size: 11; -fx-padding: 8 16; -fx-background-color: " + ACCENT_RED +
                "; -fx-text-fill: " + TEXT_WHITE + "; -fx-font-weight: bold; " +
                "-fx-border-radius: 3; -fx-cursor: hand;");
        apply.setOnAction(e -> applyFilters());

        Button reset = new Button("🔄 Reset");
        reset.setStyle("-fx-font-size: 11; -fx-padding: 8 16; -fx-background-color: #404050; " +
                "-fx-text-fill: " + TEXT_WHITE + "; -fx-font-weight: bold; " +
                "-fx-border-radius: 3; -fx-cursor: hand;");
        reset.setOnAction(e -> {
            genreFilter.getSelectionModel().clearSelection();
            countryFilter.getSelectionModel().clearSelection();
            minScoreFilter.clear();
            searchText.clear();
            filmData.setAll(platform.getFilms());
        });

        Button sortTop = new Button("⭐ Top 10");
        sortTop.setStyle("-fx-font-size: 11; -fx-padding: 8 16; -fx-background-color: " + ACCENT_ORANGE +
                "; -fx-text-fill: " + TEXT_WHITE + "; -fx-font-weight: bold; " +
                "-fx-border-radius: 3; -fx-cursor: hand;");
        sortTop.setOnAction(e -> filmData.setAll(platform.topNByScore(10)));

        return new ToolBar(new Label("🎬 Filters:"), genreFilter, countryFilter, minScoreFilter, searchText, apply, reset, new Separator(), sortTop);
    }

    private void styleComboBox(ComboBox<?> combo) {
        combo.setStyle("-fx-control-inner-background: #1a1f3a; -fx-text-fill: " + TEXT_WHITE +
                "; -fx-font-size: 11; -fx-padding: 8; -fx-border-color: " + BORDER_COLOR + ";");
    }

    private void styleTextField(TextField field) {
        field.setStyle("-fx-control-inner-background: #1a1f3a; -fx-text-fill: " + TEXT_WHITE +
                "; -fx-font-size: 11; -fx-padding: 8; -fx-border-color: " + BORDER_COLOR + ";");
    }

    private GridPane buildAddForm() {
        GridPane g = new GridPane();
        g.setPadding(new Insets(20));
        g.setHgap(20);
        g.setVgap(15);
        g.setStyle("-fx-background-color: " + CARD_BG + ";");

        codeInput = new TextField();
        codeInput.setPromptText("M001, S001, etc.");
        styleTextField(codeInput);

        nameInput = new TextField();
        nameInput.setPromptText("Film name");
        styleTextField(nameInput);

        genreInput = new ComboBox<>(FXCollections.observableArrayList(Genre.values()));
        genreInput.setPromptText("Select Genre");
        genreInput.setPrefWidth(200);
        styleComboBox(genreInput);

        countryInput = new ComboBox<>(FXCollections.observableArrayList(Country.values()));
        countryInput.setPromptText("Select Country");
        countryInput.setPrefWidth(200);
        styleComboBox(countryInput);

        starsInput = new Spinner<>(0.0, 5.0, 3.0, 0.5);
        starsInput.setEditable(true);
        starsInput.setPrefWidth(120);
        styleSpinner(starsInput);

        scoreInput = new Spinner<>(0.0, 10.0, 7.0, 0.1);
        scoreInput.setEditable(true);
        scoreInput.setPrefWidth(120);
        styleSpinner(scoreInput);

        ageInput = new Spinner<>(0, 21, 13);
        ageInput.setPrefWidth(120);
        styleSpinner(ageInput);

        releaseInput = new DatePicker(LocalDate.now());
        releaseInput.setPrefWidth(150);
        releaseInput.setStyle("-fx-font-size: 11; -fx-control-inner-background: #1a1f3a;");

        durationInput = new TextField();
        durationInput.setPromptText("Example: 02:30");
        styleTextField(durationInput);

        String labelStyle = "-fx-text-fill: " + ACCENT_RED + "; -fx-font-size: 12; -fx-font-weight: bold;";

        int r = 0;
        addLabeledControl(g, "Code", codeInput, labelStyle, r++);
        addLabeledControl(g, "Name", nameInput, labelStyle, r++);
        addLabeledControl(g, "Genre", genreInput, labelStyle, r++);
        addLabeledControl(g, "Country", countryInput, labelStyle, r++);
        addLabeledControl(g, "⭐ Stars (0-5)", starsInput, labelStyle, r++);
        addLabeledControl(g, "📊 Score (0-10)", scoreInput, labelStyle, r++);
        addLabeledControl(g, "Age Required", ageInput, labelStyle, r++);
        addLabeledControl(g, "📅 Release Date", releaseInput, labelStyle, r++);
        addLabeledControl(g, "⏱️ Duration (HH:mm)", durationInput, labelStyle, r++);

        Button addBtn = new Button("➕ Add Movie");
        addBtn.setStyle("-fx-font-size: 13; -fx-padding: 12 30; -fx-background-color: " + ACCENT_RED +
                "; -fx-text-fill: " + TEXT_WHITE + "; -fx-font-weight: bold; " +
                "-fx-border-radius: 5; -fx-cursor: hand;");
        addBtn.setOnAction(e -> onAddMovie());
        g.add(addBtn, 1, r);

        return g;
    }

    private void addLabeledControl(GridPane g, String labelText, Control control, String labelStyle, int row) {
        Label label = new Label(labelText);
        label.setStyle(labelStyle);
        g.add(label, 0, row);
        g.add(control, 1, row);
        GridPane.setHgrow(control, Priority.ALWAYS);
    }

    private void styleSpinner(Spinner<?> spinner) {
        spinner.setStyle("-fx-control-inner-background: #1a1f3a; -fx-text-fill: " + TEXT_WHITE +
                "; -fx-font-size: 11; -fx-border-color: " + BORDER_COLOR + ";");
    }

    private void onAddMovie() {
        String code = codeInput.getText();
        String name = nameInput.getText();
        Genre genre = genreInput.getValue();
        Country country = countryInput.getValue();
        double stars = starsInput.getValue();
        double score = scoreInput.getValue();
        int age = ageInput.getValue();
        LocalDate release = Optional.ofNullable(releaseInput.getValue()).orElse(LocalDate.now());
        LocalTime duration;
        String durText = Optional.ofNullable(durationInput.getText()).orElse("").trim();
        if (!durText.isEmpty()) {
            try { duration = LocalTime.parse(durText); } catch (Exception ex) {
                showAlert(Alert.AlertType.WARNING, "❌ Validation Error", "Duration must be HH:mm format");
                return;
            }
        } else {
            duration = LocalTime.of(1, 30);
        }

        if (code == null || code.isBlank() || name == null || name.isBlank() || genre == null || country == null) {
            showAlert(Alert.AlertType.WARNING, "❌ Validation Error", "Please fill: Code, Name, Genre, Country");
            return;
        }

        Optional<Film> existing = platform.findByCode(code);
        if (existing.isPresent() && existing.get().getScore10() > score) {
            showAlert(Alert.AlertType.INFORMATION, "⏭️ Skipped", "Film '%s' already exists with higher score".formatted(code));
            return;
        }

        Movie movie = new Movie(name, code, stars, score, release, genre, age, country, duration);
        platform.addFilm(movie);
        applyFilters();
        clearForm();
        showAlert(Alert.AlertType.INFORMATION, "✅ Success", "Movie '%s' added successfully!".formatted(name));
    }

    private void clearForm() {
        codeInput.clear();
        nameInput.clear();
        genreInput.getSelectionModel().clearSelection();
        countryInput.getSelectionModel().clearSelection();
        starsInput.getValueFactory().setValue(3.0);
        scoreInput.getValueFactory().setValue(7.0);
        ageInput.getValueFactory().setValue(13);
        releaseInput.setValue(LocalDate.now());
        durationInput.clear();
    }

    private void applyFilters() {
        Genre g = genreFilter.getValue();
        Country c = countryFilter.getValue();
        String search = Optional.ofNullable(searchText.getText()).orElse("").trim().toLowerCase(Locale.ROOT);
        Double minScoreTemp = null;
        if (!minScoreFilter.getText().isBlank()) {
            try { minScoreTemp = Double.parseDouble(minScoreFilter.getText()); } catch (Exception ignored) {}
        }
        final Double minScore = minScoreTemp;

        var stream = platform.getFilms().stream();
        if (g != null) stream = stream.filter(f -> f.getGenre() == g);
        if (c != null) stream = stream.filter(f -> f.getCountry() == c);
        if (minScore != null) stream = stream.filter(f -> f.getScore10() >= minScore);
        if (!search.isEmpty()) stream = stream.filter(f -> f.getName().toLowerCase(Locale.ROOT).contains(search) || f.getCode().toLowerCase(Locale.ROOT).contains(search));

        filmData.setAll(stream.sorted(Comparator.comparing(Film::getReleaseDate)).collect(Collectors.toList()));
    }

    private void seedDemoData() {
        try {
            List<Film> films = TestNetflix.loadFilms();
            platform.addAll(films);
        } catch (Exception e) {
            System.out.println("📌 Demo data loaded (or file not found): " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.getDialogPane().setStyle("-fx-background-color: " + CARD_BG + "; -fx-text-fill: " + TEXT_WHITE + ";");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

