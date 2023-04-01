import Characters.*;

import javax.crypto.SealedObject;
import javax.swing.*;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Program {
    private static PointTypeCharacter PlayerCharacter;
    private static RangeTypeCharacter EnemyCharacter;
    private static JFrame ActualFrame;
    public static void main(String[] args) {
        FirstFrame();
    }

    public static void FirstFrameSetCharacter(PointTypeCharacter character) {
        PlayerCharacter = character;
        SecondFrame();
    }

    public static void ExitProgram() {
        exit(-1);
    }

    private static void FirstFrame() {
        ActualFrame = new FirstFrame();
    }
    private static void SecondFrame() {
        EnemyCharacter = RangeTypeCharacter.CreateRandomCharacter("Enemy");
        ArrayList<String> Log = FightSimulation.StartSimulation(PlayerCharacter, EnemyCharacter);

        ActualFrame = new SecondFrame(PlayerCharacter, EnemyCharacter, Log);
    }
}
