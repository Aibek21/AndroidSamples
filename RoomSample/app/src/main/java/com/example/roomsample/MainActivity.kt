package com.example.roomsample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.roomsample.dao.*
import com.example.roomsample.model.*

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase
    lateinit var userDao: UserDao
    lateinit var libraryDao: LibraryDao
    lateinit var playlistDao: PlaylistDao
    lateinit var songDao: SongDao
    lateinit var playlistSongCrossRefDao: PlaylistSongCrossRefDao
    lateinit var users: List<User>
    lateinit var userAndLibraries: List<UserAndLibrary>
    lateinit var userWithPlaylists: List<UserWithPlaylists>
    lateinit var playlistWithSongs: List<PlaylistWithSongs>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyApplication.instance.getDatabase()!!
        userDao = db.userDao()
        libraryDao = db.libraryDao()
        playlistDao = db.playlistDao()
        songDao = db.songDao()
        playlistSongCrossRefDao = db.playlistSongCrossRefDao()

//        userAndLibraries = userDao.getUsersAndLibraries()
//        users = userDao.getAll()
//        for (user in users) {
//            Log.e("User:", user.uid.toString() + " " + user.firstName + " " + user.lastName)
//            Log.e(
//                "Address:",
//                user.address!!.street + " " + user.address!!.state + " " + user.address!!.city + " " + user.address!!.postCode
//            )
//        }

//        for (userAndLibrary in userAndLibraries) {
//            Log.e(
//                "User:",
//                userAndLibrary.user.uid.toString() + " " + userAndLibrary.user.firstName + " " + userAndLibrary.user.lastName
//            )
//            Log.e(
//                "Address:",
//                userAndLibrary.user.address!!.street + " " + userAndLibrary.user.address!!.state + " " + userAndLibrary.user.address!!.city + " " + userAndLibrary.user.address!!.postCode
//            )
//            Log.e("Library", userAndLibrary.library.title)
//
//        }

//        userWithPlaylists = userDao.getUsersWithPlaylists()
//        for (up in userWithPlaylists) {
//            Log.e(
//                "User:",
//                up.user.uid.toString() + " " + up.user.firstName + " " + up.user.lastName
//            )
//            Log.e(
//                "Address:",
//                up.user.address!!.street + " " + up.user.address!!.state + " " + up.user.address!!.city + " " + up.user.address!!.postCode
//            )
//            for (playlist in up.playlists) {
//                Log.e("Playlist", playlist.playlistId.toString() + " " + playlist.playlistName)
//            }
//
//        }

        playlistWithSongs = playlistDao.getPlaylistsWithSongs()
        for (ps in playlistWithSongs) {
            Log.e("Playlist", ps.playlist.playlistName)
            for (song in ps.songs) {
                Log.e("Song", song.songName)
            }
        }

    }


    fun onClick(v: View) {
        if (v.id == R.id.add_button) {
            var user = User()
            user.firstName = "NameWithAddress1"
            user.lastName = "LastNameWithAddress1"
            var address = Address("Tole bi", "Almaty", "Almaty", "050000")
            user.address = address

            var userId = userDao.insert(user)

            var library = Library()
            library.title = "User's Library"
            library.userOwnerId = userId
            var libraryId = libraryDao.insert(library)

            Log.e("LibraryId", libraryId.toString())

            var songList: MutableList<Song> = ArrayList()

            for (i in 1..5) {
                var song = Song()
                song.songName = "Song $i $userId"
                song.artist = "Artitst $i $userId"
                song.songId = songDao.insert(song)
                songList.add(song)
            }

            var playLists: MutableList<Playlist> = ArrayList()
            for (i in 1..5) {
                var playlist = Playlist()
                playlist.userCreatorId = userId
                playlist.playlistName = "PlayList $i"
                playlist.playlistId = playlistDao.insert(playlist)
                playLists.add(playlist)
            }

            for (i in 0..4) {
                var playlistSongCrossRef =
                    PlaylistSongCrossRef(playLists.get(i).playlistId!!, songList.get(i).songId!!)
                playlistSongCrossRefDao.insert(playlistSongCrossRef)
            }
        } else if (v.id == R.id.delete_button) {
            userDao.delete(users.get(0))
        } else {
            var user = users.get(0)
            user.firstName = "OtherName"
            userDao.update(user)
        }
    }
}