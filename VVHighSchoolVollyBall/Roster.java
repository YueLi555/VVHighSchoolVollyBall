import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// Roster class
public class Roster {
    
    private ArrayList<Player> playerList;
    
    // Default constructor
    public Roster() {
        playerList = new ArrayList<Player>();
    }
    
    // Overloaded constructor

    public Roster(String _fileName) throws IOException {
        playerList = new ArrayList<Player>();
        FileInputStream _rosterFile = new FileInputStream(_fileName);
        Scanner _scanner = new Scanner(_rosterFile);

        while (_scanner.hasNextLine()) {
            String _line = _scanner.nextLine().trim();
            if (!_line.isEmpty()) {
                Scanner _line_scanner = new Scanner(_line);
                if (_line_scanner.hasNext()) {
                    String _rosterName = _line_scanner.next() + " " + _line_scanner.next();
                    if (_line_scanner.hasNextDouble()) {
                        double _rosterAttacks = _line_scanner.nextDouble();
                        if (_line_scanner.hasNextDouble()) {
                            double _rosterBlocks = _line_scanner.nextDouble();
                            Player _new_player = new Player(_rosterName, _rosterAttacks, _rosterBlocks);
                            playerList.add(_new_player);

                            System.out.printf("%s (attack = %.2f, block = %.2f)%n", _rosterName, _rosterAttacks, _rosterBlocks);
                        }
                    }
                }
                _line_scanner.close();
            }
        }

        _scanner.close();
        _rosterFile.close();
    }
    
    // Print all players
    public void printAllPlayers() {
            for (Player player : playerList) {
                player.printInfo();
            }

    }
    
    // Add a player
    public void addPlayer(String _players_name, double _attack_scores, double _block_scores) {
        Player _new_player = new Player(_players_name, _attack_scores, _block_scores);
        playerList.add(_new_player);
        System.out.println("Current player count: " + getPlayerCount());
    }
    
    // Get player count
    public int getPlayerCount() {
        return playerList.size();
    }
    
    // Get player by name
    public Player getPlayerByName(String _players_names) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(_players_names)) {
                return player;
            }
        }
        return null; //otherwise return null 
    }
    
    // Print top blockers
  public void printTopBlockers() {
    Player _first_player = null;
    Player _second_player = null;
    
    for (Player _player : playerList) {
        if (_first_player == null || _player.getBlockScore() > _first_player.getBlockScore()) {
            _second_player = _first_player;
            _first_player = _player;
        } else if (_second_player == null || _player.getBlockScore() > _second_player.getBlockScore()) {
            _second_player = _player;
        }
    }
    
    if (_first_player != null) {
        _first_player.printInfo();
    }
    if (_second_player != null) {
        _second_player.printInfo();
    }
}

    
    // Print top attackers
    public void printTopAttackers() {
        Player _first_player = null;
        Player _second_player = null;
        
        for (Player player : playerList) {
            if (_first_player == null || player.getAttackScore() > _first_player.getAttackScore()) {
                _second_player = _first_player;
                _first_player = player;
            } else if (_second_player == null || player.getAttackScore() > _second_player.getAttackScore()) {
                _second_player = player;
            }
        }

        if (_first_player != null) {
            _first_player.printInfo();
        }
        if (_second_player != null) {
            _second_player.printInfo();
        }
    }
}
