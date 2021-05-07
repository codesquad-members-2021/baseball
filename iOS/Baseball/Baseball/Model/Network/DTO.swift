

import Foundation

struct GameDTO: Decodable {
    private (set) var game: Game
}

struct GameListDTO: Decodable {
    private (set) var gameList: GameList
}
