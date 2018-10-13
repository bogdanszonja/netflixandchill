import {Component, OnInit} from '@angular/core';

import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn = false;
  searchToggle = false;

  constructor(private dataService: DataService) {
  }

  ngOnInit() {
  }

  showSearchField(): void {
    this.searchToggle = !this.searchToggle;
  }

  search(searchInput: string): void {
    console.log(searchInput);
    this.searchToggle = !this.searchToggle;
  }

  join(): void {
    this.dataService.requestJoinForm('join');
  }

  login(): void {
    this.isLoggedIn = true;
    this.dataService.requestLoginForm('login');
  }

  logout(): void {
    this.isLoggedIn = false;
  }
}
