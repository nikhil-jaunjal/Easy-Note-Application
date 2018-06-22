import { Component, OnInit } from '@angular/core';

import {UserService} from '../../shared-service/user.service';
import {NoteService} from '../../shared-service/note.service';

import {User} from '../../classes/user';
import {Note} from '../../classes/note';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private users:User[];
  private notes:Note[];
  constructor(private _userService:UserService, private _noteService:NoteService) { }

  ngOnInit() {
    this._userService.getUsers().subscribe((users)=>{
      console.log(users);
      this.users=users;
    },(error)=>{
      console.log(error);
    })


    this._noteService.getNotes().subscribe((notes)=>{
      console.log(notes);
      this.notes=notes;
    },(error)=>{
      console.log(error);
    })
  }
}
