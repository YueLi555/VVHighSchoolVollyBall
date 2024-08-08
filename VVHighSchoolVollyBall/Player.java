// Implement your Player class in this file

// Classs Player
public class Player{
      // private instance variables 
      private String name;
      private double attackScore;
      private double blockScore;
      
      // public constructor method 
      // overloaded constructor with three arguments 
      public Player(String _player_name, double _attack_score, double _block_score){
               //assigning to private instance variables 
               this.name = _player_name;
               this.attackScore = _attack_score;
               this.blockScore = _block_score;
         }
         
      // public methods 
      
      // getter - getName() 
            public String getName(){
                  //return name
                  return name;
               }
               // getAttackScore()
            public double getAttackScore(){
                  return attackScore;
               }
               // getBlockScore()
               public double getBlockScore(){
                  return blockScore;
                  }
                  
      // setter - setAttackScore() - no return value - one double argument 
            public void setAttackScore(double _set_attack_score){
                 this.attackScore =  _set_attack_score;
               }
               // setBlockScore()
               public void setBlockScore(double _set_block_score){
                     this.blockScore = _set_block_score;
                  }
      // printInfo() - no argument - no return anything 
      public  void printInfo(){
            // output for name, attackScore, blockScore
            System.out.printf("%s (attack = %.2f, block = %.2f)\n", name, attackScore, blockScore);
         }
         


   }