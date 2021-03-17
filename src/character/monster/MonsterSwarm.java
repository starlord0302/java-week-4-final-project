package character.monster;

import java.util.ArrayList;

import character.GameCharacter;
import map.Board;
import map.Level;
import map.FieldType;
import util.Position;

public class MonsterSwarm {
  private ArrayList<GameCharacter> swarm;
  private Board board;

  public MonsterSwarm(Board board) {
    this.board = board;
    this.swarm = createMonsters();
  }

  public Monster createMonster(int level, int field, char initial) {
    double attackPoint = Monster.BASE_MONSTER_ATTACK * (level + 1);
    double healthPoint = (Monster.BASE_MONSTER_HEALTH * (level + 1)) - Monster.BASE_MONSTER_ATTACK * level;
    return new Monster(healthPoint, attackPoint, new Position(level, field), initial);
  }

  public Monster createBoss(int level, int field, char initial) {
    double attackPoint = Monster.BASE_BOSS_ATTACK * (level + 1);
    double healthPoint = (Monster.BASE_BOSS_HEALTH * (level + 1)) - Monster.BASE_BOSS_ATTACK * level;
    return new Monster(healthPoint, attackPoint, new Position(level, field), initial);
  }

  public ArrayList<GameCharacter> createMonsters() {
    ArrayList<Level> levels = this.board.getBoard();
    ArrayList<GameCharacter> monsters = new ArrayList<>();

    for (int i = 0; i < this.board.getNumberOfLevels(); i++) {
      for (int j = 0; j < this.board.getNumberOfFields(); j++) {
        char initial = levels.get(i).getField(j).getFieldType().name().charAt(0);
        if (levels.get(i).getField(j).getFieldType() == FieldType.MONSTER) {
          monsters.add(this.createMonster(i, j, initial));
        } else if (levels.get(i).getField(j).getFieldType() == FieldType.BOSS) {
          monsters.add(this.createBoss(i, j, initial));
        }
      }
    }

    return monsters;
  }

  public ArrayList<GameCharacter> getSwarm() {
    return this.swarm;
  }

  public GameCharacter getMonster(int level, int field) {
    GameCharacter monster = null;

    for (int i = 0; i < this.swarm.size(); i++) {
      monster = this.swarm.get(i);
      if (monster.getPosition().getLevel() == level && monster.getPosition().getField() == field) {
        monster = this.swarm.remove(i);
        break;
      }
    }

    return monster;
  }

  public void printMonsterSwarm() {
    for (int i = 0; i < this.swarm.size(); ++i) {
      this.swarm.get(i).printGameCharacter();
    }
  }
}