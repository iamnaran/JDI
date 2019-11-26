# Android Sample Project Template 2020

Android Injectors, Dagger2, Room, Shared Pref, rXjava, Fast Android Networking Library


# About Fast Android Networking Library

Fast Android Networking Library is a powerful library for doing any type of networking in Android applications which is made on top of OkHttp Networking Layer.

Fast Android Networking Library takes care of each and everything. So you don't have to do anything, just make request and listen for the response.


# Why use Fast Android Networking ?

Recent removal of HttpClient in Android Marshmallow(Android M) made other networking libraries obsolete.
No other single library does each and everything like making request, downloading any type of file, uploading file, loading image from network in ImageView, etc. There are some libraries but they are outdated.
No other library provides simple interface for doing all types of things in networking like setting priority, cancelling, etc.
As it uses Okio , No more GC overhead in android applications. Okio is made to handle GC overhead while allocating memory. Okio does some clever things to save CPU and memory.
It uses OkHttp , more importantly it supports HTTP/2.

