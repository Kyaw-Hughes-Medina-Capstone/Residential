mapboxgl.accessToken = MAPBOX_KEY
let map = new mapboxgl.Map({
    container: 'map', // container ID
    style: 'mapbox://styles/mapbox/streets-v12',
    center: [-97.733330, 30.266666],
    zoom: 9,
});

// document.getElementById('searchButton').addEventListener('click', function (event) {
//     event.preventDefault();
//
//     let zipCode = document.getElementById('zipcodeInput').value;
//     updateMapAndMechanics(zipCode);
// });

// function updateMapAndMechanics(zipCode) {
//     fetch(`https://api.mapbox.com/geocoding/v5/mapbox.places/${encodeURIComponent(zipCode)}.json?access_token=${MAPBOX_KEY}`)
//         .then((geocodeResponse) => geocodeResponse.json())
//         .then((geocodeResponse) => {
//             let coordinates = geocodeResponse.features[0].center;
//             map.setCenter(coordinates);
//             fetch(`https://auto-connect.org/users/mechanic-list?zipcode=${zipCode}`)
//                 // fetch(`http://localhost:8080/users/mechanic-list?zipcode=${zipCode}`)
//                 .then((response) => response.json())
//                 .then((response) => {
//                     console.log("DATA:", response);
//                     response.forEach(mechanic => {
//                         let firstName = mechanic.first_name;
//                         let lastName = mechanic.last_name;
//                         let street = mechanic.address_street;
//                         let city = mechanic.address_city;
//                         let zipCode = mechanic.address_zip;
//                         let state = mechanic.address_state
//
//                         let searchQuery = `${street}, ${city}, ${zipCode},${state}`;
//
//                         let profileLink = document.createElement('a');
//                         profileLink.href = `/profile/${mechanic.id}`;
//                         profileLink.textContent = `${firstName} ${lastName}`;
//                         profileLink.addEventListener('click', function (event) {
//                             event.stopPropagation();
//                         });
//
//                         fetch(`https://api.mapbox.com/geocoding/v5/mapbox.places/${encodeURIComponent(searchQuery)}.json?access_token=${MAPBOX_KEY}`)
//                             .then((geocodeResponse) => geocodeResponse.json())
//                             .then((geocodeResponse) => {
//                                 let coordinates = geocodeResponse.features[0].center;
//                                 console.log("Creating new marker...")
//                                 new mapboxgl.Marker()
//                                     .setLngLat(coordinates)
//                                     .setPopup(new mapboxgl.Popup().setHTML(getPopupContent(profileLink, firstName, lastName, street, city, state, zipCode)))
//                                     .addTo(map);
//                                 console.log(map)
//                                 // populateMechanicList(mechanic);
//                             })
//                             .catch((error) => {
//                                 console.error('Error ', error);
//                             });
//                     });
//                 })
//                 .catch((error) => {
//                     console.error('Error', error);
//                 });
//         })
//         .catch((error) => {
//             console.error('Error ', error);
//         });
// }



// function getPopupContent(profileLink, firstName, lastName, street, city, zipCode, state) {
//     return `<h3>${profileLink.outerHTML}</h3>
//         <p>${street}, ${city}, ${zipCode}, ${state}</p>`
// }