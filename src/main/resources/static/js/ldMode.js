
"use strict";

document.addEventListener("DOMContentLoaded", function () {
    let icon = document.getElementById("icon");
    icon.addEventListener("click", function () {
        document.body.classList.toggle("light-theme");
        if (document.body.classList.contains("light-theme")) {
            icon.className = "fa fa-moon-o";
        } else {
            icon.className = "fa fa-sun-o";
        }
    });
});
