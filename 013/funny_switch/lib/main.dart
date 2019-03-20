import 'package:flutter/material.dart';
import 'package:flare_flutter/flare_actor.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flare Funny Switch',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: FlareFunnySwitch(title: 'Flare Funny Switch'),
    );
  }
}

class FlareFunnySwitch extends StatefulWidget {
  FlareFunnySwitch({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _FlareFunnySwitchState createState() => _FlareFunnySwitchState();
}

class _FlareFunnySwitchState extends State<FlareFunnySwitch> {
  String _animationName = "Off";
  bool state = false;

  void switchState() {
    setState(() {
      if (state) {
        _animationName = "Off";
        state = false;
      } else {
        _animationName = "On";
        state = true;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromARGB(97, 97, 97, 97),
      body: Container(
        padding: EdgeInsets.all(32.0),
          child: Column(
            children: <Widget>[
              Container(
                padding: EdgeInsets.only(top: 100),
                child: Text(_animationName.toUpperCase(),
                  style: TextStyle(color: Colors.white, fontSize: 50),
                ),
              ),
              Container(
                width: 1000,
                height: 500,
                child: GestureDetector(
                  child: FlareActor(
                    "assets/Smiley Switch.flr",
                    alignment: Alignment.center,
                    fit: BoxFit.contain,
                    animation: _animationName,
                  ),
                  onTap: switchState,
                )
              )
            ],
          )
      ),
    );
  }
}
