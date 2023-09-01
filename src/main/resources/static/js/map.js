

"use strict";

mapboxgl.accessToken = mapBoxKey;
const map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v12',
    center: [-97.733330, 30.266666],
    zoom: 8
});


// Array to store marker instances
const markers = [];

// Perform geocoding and create markers for each marker element
document.querySelectorAll('.card-address').forEach(cardAddress => {
    const address = cardAddress.textContent; // Get the address text
    console.log(address);
    updateMap(address);
});


// Perform geocoding to get coordinates and update the map
function updateMap(address) {

    fetch(`https://api.mapbox.com/geocoding/v5/mapbox.places/${encodeURIComponent(address)}.json?access_token=${mapBoxKey}`)
        .then(response => response.json())
        .then(geocodeResponse => {
            if (geocodeResponse.features.length > 0) {
                const coordinates = geocodeResponse.features[0].center;

                // Create a marker for each property
                const marker = new mapboxgl.Marker()
                    .setLngLat(coordinates)
                    .addTo(map);
                console.log(coordinates);
                console.log(map);
                markers.push(marker); // Store the marker instance
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Adjust map's center and zoom to fit all markers
map.on('load', () => {
    const bounds = new mapboxgl.LngLatBounds();
    markers.forEach(marker => bounds.extend(marker.getLngLat()));
    map.fitBounds(bounds, { padding: 50 });
});

