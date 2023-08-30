"use strict";
mapboxgl.accessToken = accessKey;
const map = new mapboxgl.Map({
    container: 'map', // container ID
// Choose from Mapbox's core styles, or make your own style with Mapbox Studio
    style: 'mapbox://styles/mapbox/streets-v12', // style URL
    center: [ -97.74034452371761, 30.274672822809205], // starting position [lng, lat]
    zoom: 9 // starting zoom
});