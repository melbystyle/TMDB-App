package io.melbybaldove.data.movie.entity

import io.melbybaldove.commons.mapper.Mapper
import io.melbybaldove.domain.movie.entity.Movie
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Melby Baldove
 * melbourne.baldove@owtoph.com
 */
object MovieEntityMapper : Mapper<MovieEntity, Movie> {
    private val df = SimpleDateFormat("yyy-MM-DD", Locale.US)
    override fun map(from: MovieEntity) = Movie(
            id = from.id.toString(),
            title = from.title ?: "No Title",
            description = from.overview ?: "No Overview",
            poster = URI("https://image.tmdb.org/t/p/w500${from.poster_path}"),
            date = (if (!from.release_date.isNullOrEmpty()) from.release_date else null)?.let(df::parse)
    )
}