package david.com.youtubeclone.models

data class Movie (
    var snippet: MovieSnippet
)

data class MovieSnippet (

    var title: String,
    var description: String,
    var thumbnails: Thumbnails
)

data class Thumbnails(
    var default: DefaultThumbnails
)

data class  DefaultThumbnails(
    var url: String,
    var width: Int,
    var height: Int
)
