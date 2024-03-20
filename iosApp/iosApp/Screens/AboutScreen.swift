//
//  AboutScreen.swift
//  iosApp
//
//  Created by Saw Pyae Yadanar on 14/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
  @Environment(\.dismiss) var dismiss
  var body: some View {
    NavigationStack {
      AboutListView()
        .navigationTitle("About Device")
        .toolbar {
          ToolbarItem {
            Button {
              dismiss()
            } label: {
              Text("Done")
                .bold()
            }
          }
        }
    }
  }
}

#Preview {
  AboutScreen()
}
