import {Component, OnInit} from '@angular/core';
import * as L from 'leaflet';
import 'leaflet-routing-machine';
import {GpsDataService} from "../services/gps-data.service";
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit{
  map: L.Map | undefined;
  polyline: L.Polyline | undefined;
  constructor(private gpsDataService: GpsDataService) {

  }
  ngOnInit() {
    this.loadMap();
    setTimeout(() => this.animateMarker(), 2000);
  }

  loadMap() {
    this.map = L.map('mapId');
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '© OpenStreetMap Test SORHRANI'
    }).addTo(this.map);

    // Récupération du Lat et long via.
    this.gpsDataService.getGpsCoordinates().subscribe((data: any) => {
      const latlngs = data.map((coord: { latitude: any; longitude: any; }) => [coord.latitude, coord.longitude]);

      // Vérifier s'il y a des coordonnées disponibles
      if (latlngs.length > 0) {

        // Création de la polyline.
        // @ts-ignore
        this.polyline = L.polyline(latlngs, { color: 'red' }).addTo(this.map);

        // @ts-ignore
        this.map.fitBounds(this.polyline.getBounds());

        const startPoint = latlngs[0];  // Premier point de la liste
        // @ts-ignore
        L.marker(startPoint).addTo(this.map).bindPopup('Point A - Start').openPopup();

        const endPoint = latlngs[latlngs.length - 1];  // Dernier point de la liste
        // @ts-ignore
        L.marker(endPoint).addTo(this.map).bindPopup('Point B - End');

      } else {
        console.error('Aucune donnée GPS disponible.');
      }
    });
  }

  animateMarker() {
    let index = 0;
    // @ts-ignore
    const latlngs = this.polyline.getLatLngs();

    // @ts-ignore
    const marker = L.marker(latlngs[0]).addTo(this.map);
    const moveMarker = () => {
      if (index < latlngs.length) {
        console.log("zoom",latlngs[index].toString());
        // @ts-ignore
        marker.setLatLng(latlngs[index]);
        // @ts-ignore
        this.map.setView(latlngs[index], 17);
        // @ts-ignore
        const info = `Point ${index + 1}: Latitude ${latlngs[index].lat}, Longitude ${latlngs[index].lng}`;
        marker.bindPopup(info).openPopup();
        index++;
        setTimeout(moveMarker, 100);
      }else {
        // @ts-ignore
        this.map.fitBounds(this.polyline.getBounds());
        // @ts-ignore
        this.map.removeLayer(marker);
      }

    };
    moveMarker();
  }

}
