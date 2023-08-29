package pl.pingpong.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Component
@Data
@ToString
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int gameNumber;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @OneToOne
    private Player homePlayer;

    @OneToOne
    private Player guestPlayer;
    @OneToOne
    private Player winner;
    @OneToOne
    private Player looser;

    private String resultHome;
    private String resultGuestTeam;

    @OneToMany(mappedBy = "game")
    private List<GameSets> gameSets;

}