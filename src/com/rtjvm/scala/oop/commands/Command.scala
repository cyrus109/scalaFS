package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Command {
 def apply(state: State) : State
}

object Command{
  val MKDIR = "mkdir"
  def emptyCommand : Command = ???
  def incompleteCommand(name: String) : Command = ???
  def from(input: String) : Command = {
    val tokens: Array[String] = input.split(" ")
    if (tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if(tokens.length <2 ) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    }
    new UnknownCommand
  }
}