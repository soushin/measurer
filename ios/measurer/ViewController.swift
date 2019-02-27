//
//  ViewController.swift
//  measurer
//
//  Created by soushin on 2019/02/26.
//  Copyright © 2019 soushin. All rights reserved.
//

import UIKit
import main

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        MeasurerProxyKt.pageTracking(tid: "your tracking id") // value is like `UA-12345678-1`
    }
}
