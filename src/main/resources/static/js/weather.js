// "use strict";
// mapboxgl.accessToken = 'pk.eyJ1Ijoia2hpbmVtZW1la3lhdyIsImEiOiJjbGk5N3R2Mm4xOWg4M2xuMXByczB3MTJwIn0.O9sQSWZd1SIuKw4XZ3uTrA';
// const map = new mapboxgl.Map({
//     container: 'map',
// // Choose from Mapbox's core styles, or make your own style with Mapbox Studio
//     style: 'mapbox://styles/mapbox/streets-v12',
//     center: [12.550343, 55.665957],
//     zoom: 8
// });
//
// // Create a default Marker and add it to the map.
// const marker1 = new mapboxgl.Marker()
//     .setLngLat([12.554729, 55.70651])
//     .addTo(map);
//
// // Create a default Marker, colored black, rotated 45 degrees.
// const marker2 = new mapboxgl.Marker({ color: 'black', rotation: 45 })
//     .setLngLat([12.65147, 55.608166])
//     .addTo(map);
//
//
//
//
//
// 'use strict';
//
// // accessing the map using key
// let accessToken = mapboxgl.accessToken = accessKey;
// accessToken = mapboxgl.accessToken;
//
// // adding coordinates on HTML
// let coordinates = document.getElementById('coordinates');
//
// // modifying map with center and zoom
// let weatherMap = new mapboxgl.Map({
//     container: 'map',
//     style: 'mapbox://styles/mapbox/streets-v12',
//     center: [-97.720569, 31.084211],
//     zoom: 5
// });
//
// // adding marker on map
// let marker = new mapboxgl.Marker({
//     draggable: true
// })
//     .setLngLat([-97.720569, 31.084211])
//     .addTo(weatherMap);
//
// // Weather info for student location
// function weatherInfo(lat, lon) {
//     $.get("http://api.openweathermap.org/data/2.5/forecast", {
//         APPID: weather_Map_Key,
//         lat: lat,
//         lon: lon,
//         units: "imperial"
//     })
//         .done(function (data) {
//             console.log('5 day forecast', data);
//             let days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
//             let months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
//
//             for (let i = 0; i < 5; i++) {
//                 let dayIndex = i * 8;
//                 let currentData = data.list[dayIndex];
//                 let todayDate = new Date(currentData.dt * 1000);
//                 let currentDay = days[todayDate.getDay()];
//                 let currentMonth = months[todayDate.getMonth()];
//                 let cardHTML = `
//           <div class="card">
//             <div class="container">
//               <div class="card-date">${currentDay}, ${currentMonth} ${todayDate.getDate()}</div>
//               <div class="card-temperature">${currentData.main.temp_max} °F / ${currentData.main.temp_min} °F</div>
//               <div class="wi wi-owm-${currentData.weather[0].id}"></div>
//               <div class="card-description">Description: ${currentData.weather[0].description}</div>
//               <div class="card-humidity">Humidity: ${currentData.main.humidity}</div>
//               <div class="card-wind">Wind: ${currentData.wind.gust}</div>
//               <div class="card-pressure">Pressure: ${currentData.main.pressure}</div>
//             </div>
//           </div>
//         `;
//                 $(`#card-${i + 1}`).html(cardHTML);
//             }
//
//             $("#currentCity").html(`Current Location: ${data.city.name}, ${data.city.country}`);
//         });
// }
// //Weather info based on lng and lat
// function updateWeatherInfo(lngLat) {
//     let lat = lngLat.lat;
//     let lon = lngLat.lng;
//     weatherInfo(lat, lon);
// }
//
// // Using onDragEnd function in order to have draggable marker and print lon and lat value on webpage
// function onDragEnd() {
//     let lngLat = marker.getLngLat();
//     updateWeatherInfo(lngLat);
// }
//
// marker.on('dragend', onDragEnd);
//
// //weather info based on search
// function searchLocation(event) {
//     event.preventDefault(); // Prevent form submission from refreshing the page
//
//     let input = document.getElementById("search-box").value;
//     console.log("input is:" + input);
//
//     //Remove the existing marker if it exists
//     if (marker) {
//         marker.remove();
//     }
//
//     $.get("https://api.openweathermap.org/data/2.5/forecast", {
//         APPID: weather_Map_Key,
//         q: input,
//         zip: input,
//         units: "imperial"
//     })
//         .done(function (data) {
//             console.log('5 day forecast', data);
//             console.log(data.city.coord.lat);
//             console.log(data.city.coord.lon);
//             geocode(input, accessToken).then(function (result) {
//                 console.log(result);
//                 var newMarker = new mapboxgl.Marker({
//                     draggable: true
//                 }).setLngLat(result);
//                 newMarker.addTo(weatherMap);
//                 weatherMap.panTo({ lon: data.city.coord.lon, lat: data.city.coord.lat }, { duration: 5000 });
//
//                 // Update the marker variable to the new marker
//                 marker = newMarker;
//
//                 // Make the marker draggable
//                 marker.on('dragend', function () {
//                     onDragEnd(marker.getLngLat());
//                 });
//
//                 // Fetch weather information for the new location
//                 updateWeatherInfo(marker.getLngLat());
//             });
//
//         });
// }
//
// var inputSubmit = document.querySelector('#search');
// inputSubmit.addEventListener('click', searchLocation);
//
// weatherMap.on('click', function (e) {
//     // Remove the existing marker if it exists
//     if (marker) {
//         marker.remove();
//     }
//     // Create a new marker at the clicked coordinates
//     var newMarker = new mapboxgl.Marker({
//         draggable: true
//     }).setLngLat(e.lngLat);
//
//     newMarker.addTo(weatherMap);
//
//     // Update the marker variable to the new marker
//     marker = newMarker;
//
//     // Make the marker draggable
//     marker.on('dragend', function () {
//         onDragEnd(marker.getLngLat());
//     });
//
//     // Fetch weather information for the clicked location
//     updateWeatherInfo(marker.getLngLat());
//
// });
//
// // Fetch weather information for the initial location
// updateWeatherInfo(marker.getLngLat());
