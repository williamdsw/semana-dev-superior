
export type RecordsResponse = {
    content: RecordItem[];
    totalPages: number;
};

export type RecordItem = {
    id: number,
    moment: string,
    name: string,
    age: number,
    gameDto: GameDTO,
    genreDto: GenreDTO
}

export type GameDTO = {
    id: number,
    title: string
    platform: Platform
}

export type GenreDTO = {
    id: number,
    name: string
}

export type Platform = 'XBOX' | 'PC' | 'PLAYSTATION' | 'NINTENDO SWITCH';
