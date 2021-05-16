package hust.soict.dsai.aims.screen.playingWindow;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {
    private int length;
    private int now = 0;
    private int speed = 1;
    private boolean pause = false;
    private boolean muteStatus = false;
    private  RotateTransition rotate = new RotateTransition();

    private PauseTransition time = new PauseTransition(Duration.seconds(1));

    public controller(Media media) {
        super();
        this.length = media.getLength();
    }
    public controller(Track track) {
        super();
        this.length = track.getLength();
    }


    @FXML
    private Label moment;
    @FXML
    private ImageView mediaView;
    @FXML
    private Slider volumnSlider;
    @FXML
    private Slider progressBar;
    @FXML
    private Label label;
    @FXML
    private StackPane pane;
    @FXML
    private ImageView volumn;
    @FXML
    private ImageView muted;

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {


        rotate.setNode(mediaView);
        rotate.setDuration(Duration.millis(20000));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

        progressBar.setMax(this.length);
        int maxV = (int) progressBar.getMax();
        int minV = (int) progressBar.getMin();
        int valPerStick = (maxV - minV) / this.length;
        this.time.setOnFinished(event -> {
            progressBar.setValue(controller.this.now);
            if (controller.this.now < controller.this.length && !controller.this.pause) {
                this.time.play();
                controller.this.now += this.speed;
            } else {
            }
        });
        this.time.play();

        progressBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int second = (int) progressBar.getValue() * valPerStick;
                moment.setText("" + (second / 60) + ":" + (second % 60));
                controller.this.now = second;


            }
        });

        volumnSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if ((int) volumnSlider.getValue() == 0) {
                    mute();
                } else {
                    unmute();
                }
            }
        });
    }

    @FXML
    void playVideo() {
        this.pause = false;
        rotate.play();
        this.time.setOnFinished(event -> {
            progressBar.setValue(controller.this.now);
            if (controller.this.now < controller.this.length && !controller.this.pause) {
                this.time.play();
                controller.this.now += this.speed;
            }
        });
        this.time.play();

    }

    @FXML
    void mute() {
        volumn.setVisible(false);
        muted.setVisible(true);
        volumnSlider.setValue(0);
        this.muteStatus = true;

    }

    @FXML
    void unmute() {
        volumn.setVisible(true);
        muted.setVisible(false);
        this.muteStatus = false;
        //volumnSlider.setValue(10);

    }


    @FXML
    void pauseVideo(ActionEvent e) {
        rotate.pause();
        this.pause = true;
    }

    @FXML
    void furtherSlowDownVideo(ActionEvent e) {
        if (this.speed > 1) {
            this.speed -= 1;
        }
    }

    @FXML
    void furtherSpeedUpVideo(ActionEvent e) {
        this.speed += 1;
    }


    @FXML
    void skip5(ActionEvent e) {
        this.now += 5;
    }

    @FXML
    void back5(ActionEvent e) {
        if (this.now > 5) {
            this.now -= 5;
        } else {
            this.now = 0;
        }
    }


}